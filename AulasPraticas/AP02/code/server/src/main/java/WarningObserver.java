import io.grpc.stub.StreamObserver;
import rpcstubs.WarnMsg;

import java.util.HashMap;
import java.util.Map;

public class WarningObserver implements StreamObserver<WarnMsg> {

    public static Map<String, StreamObserver<WarnMsg>> observers = new HashMap<>();
    private String driver_key;

    public WarningObserver(String key, StreamObserver<WarnMsg> responseObserver) {
        observers.put(key, responseObserver);
    }

    @Override
    public void onNext(WarnMsg warnMsg) {

        //Broadcast the warning message to all the clients, except for the one that sent the message
        if (observers.containsKey(warnMsg.getId())) {
            for (String key : observers.keySet()) {
                if (!key.equals(driver_key)) {
                    observers.get(key).onNext(warnMsg);
                }
            }

        } else {

            //Associate the correct driver's id to the observer
            StreamObserver<WarnMsg> observer = observers.get(warnMsg.getWarning());
            observers.remove(warnMsg.getWarning());
            observers.put(warnMsg.getId(), observer);
            driver_key = warnMsg.getId();
        }
    }

    @Override
    public void onError(Throwable throwable) {
        //Remove the driver's observer from the notifications list
        observers.remove(driver_key);
        System.out.println(throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        observers.remove(driver_key);
    }
}