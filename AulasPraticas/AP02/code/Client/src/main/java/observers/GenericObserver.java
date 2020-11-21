package observers;

import io.grpc.stub.StreamObserver;

public class GenericObserver<T> implements StreamObserver<T> {
	private String objective;
	private boolean error = false;
	private boolean finished = false;

	public GenericObserver(String objective) {
		this.objective = objective;
	}

	@Override
	public void onNext(T t) {
		System.out.println("The value from " + objective + " has arrived and is " + t);
	}

	@Override
	public void onError(Throwable throwable) {
		System.out.println("The operation on " + objective + " threw an error");
		System.out.println("Error : " + throwable.getMessage());
		error=true;
	}

	@Override
	public void onCompleted() {
		System.out.println("The operation on " + objective + " was successfully completed");
		return;
	}

	public boolean isFinished (){
		return error||finished;
	}

	public boolean wasError (){
		return error;
	}
}
