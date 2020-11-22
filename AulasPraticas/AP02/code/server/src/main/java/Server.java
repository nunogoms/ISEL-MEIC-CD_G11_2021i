import centralstubs.CentralServiceGrpc;
import centralstubs.Tariff;
import centralstubs.Track;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.apache.commons.lang3.RandomStringUtils;
import rpcstubs.*;
import rpcstubs.Void;

import java.io.IOException;
import java.util.*;

public class Server extends ControlServiceGrpc.ControlServiceImplBase {

    private static final String SVC_IP = "35.230.146.225";
    private static final int REGISTER_PORT = 7000;
    private static final int SVC_PORT = 7500;
    private static final int GROUP_ID = 25;
    private static CentralServiceGrpc.CentralServiceBlockingStub blockStub;
    private static Map<String, Integer> trips = new HashMap<>();

    public static void main(String[] args) {

        try {

            //Establish a connection to the Central Server and check that the Control Server is running
            ManagedChannel channel = ManagedChannelBuilder.forAddress(SVC_IP, SVC_PORT).usePlaintext().build();
            blockStub = CentralServiceGrpc.newBlockingStub(channel);

            io.grpc.Server server = ServerBuilder.forPort(REGISTER_PORT).addService(new Server()).build();
            server.start();

            System.out.println("Server online");

            Scanner scan = new Scanner(System.in);
            scan.nextLine();

        } catch (IOException exception) {
            exception.getMessage();
            exception.printStackTrace();
        }
    }

    @Override
    public void enter(Initial request, StreamObserver<Void> responseObserver) {

        try {

            //Gather the information about the point used to access the road
            int inPoint = request.getInPoint();
            String id = request.getId();

            //Create the tuple with the client's id and the initial point
            trips.put(id, inPoint);

            //Notify the client that the entry registry was successfully performed, giving him access to the warning operation
            responseObserver.onNext(Void.newBuilder().build());
            responseObserver.onCompleted();

        } catch (Throwable throwable) {
            responseObserver.onError(throwable);
        }
    }

    @Override
    public StreamObserver<WarnMsg> warning(StreamObserver<WarnMsg> responseObserver) {

        String key = "";

        try {
            //Generate a random key in order to obtain the client's real id
            key = RandomStringUtils.random(4, true, true);
            WarnMsg message = WarnMsg.newBuilder().setWarning(key).build();
            responseObserver.onNext(message);

        } catch (Throwable throwable) {
            responseObserver.onError(throwable);
        }

        //Notify the client about the generated key, and send him an observer to create a communications channel
        return new WarningObserver(key, responseObserver);
    }

    @Override
    public void leave(FinalPoint request, StreamObserver<Payment> responseObserver) {

        try {

            //Gather the information about the point used to leave the road
            int outpoint = request.getOutPoint();
            String id = request.getId();

            //Perform a request to the Central Server, passing the start and end point to obtain the payment value
            Track track = Track.newBuilder().setInPoint(trips.get(id)).setOutPoint(outpoint).setGroup(GROUP_ID).build();
            Tariff tariff = blockStub.payment(track);
            Payment payment = Payment.newBuilder().setValue(tariff.getValue()).build();

            //Send the information to the client that he successfully leave the road and inform the value to pay
            responseObserver.onNext(payment);
            responseObserver.onCompleted();

            //Remove the tuple previously created, since the user is no longer on the road
            trips.remove(id);

        } catch (Throwable throwable) {
            responseObserver.onError(throwable);
        }
    }
}