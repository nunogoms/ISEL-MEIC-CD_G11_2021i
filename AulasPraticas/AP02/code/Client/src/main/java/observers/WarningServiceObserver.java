package observers;

import io.grpc.stub.StreamObserver;
import rpcstubs.WarnMsg;

/**
 * This observer only works with the Type Warnmsg because, it has a different behaviour from the other types
 */
public class WarningServiceObserver implements StreamObserver<WarnMsg> {

	/**
	 * We keep this as a way to maintain the state of the current Observer since a keyID exchange is made so the server
	 * 	can have the map with observers and plates
	 */

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
