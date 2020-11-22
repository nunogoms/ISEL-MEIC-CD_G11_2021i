package observers;

import io.grpc.stub.StreamObserver;
import rpcstubs.WarnMsg;

public class WarningServiceObserver implements StreamObserver<WarnMsg> {
	private boolean hasSentId = false;
	private String keyId = null;


	@Override
	public void onNext(WarnMsg warnMsg) {
		if(!hasSentId){
			keyId = warnMsg.getWarning();
			hasSentId = true;
			return;
		}
		System.out.println("\nA driver as signaled that something has happened on the road - " + warnMsg);
	}

	@Override
	public void onError(Throwable throwable) {
		System.out.println("\nThere was an error with the Control center warning control");
	}

	@Override
	public void onCompleted() {
		System.out.println("\nThank you for your travel");
	}

	public String getKeyId (){
		return keyId;
	}
}
