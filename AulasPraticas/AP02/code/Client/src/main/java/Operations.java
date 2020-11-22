import io.grpc.stub.StreamObserver;
import observers.GenericObserver;
import observers.WarningServiceObserver;
import rpcstubs.Void;
import rpcstubs.*;

import java.util.Scanner;
import java.util.function.Supplier;

public class Operations {
	private final Scanner scan = new Scanner(System.in);

	//Reference of the stub initialized so we can access the gRPC methods
	private final ControlServiceGrpc.ControlServiceStub controlServiceStub;
	private final String plate;

	//Variables used to be aware of what resources are being used currently
	private boolean isOnTheRoad = false;
	private StreamObserver<WarnMsg> warningObs;

	public Operations(ControlServiceGrpc.ControlServiceStub controlServiceStub, String plate) {
		this.controlServiceStub = controlServiceStub;
		this.plate = plate;
	}

	/**
	 * This Method closes all the resources being used by the client if forcequit = true, if not it warns the client that
	 * he cant leave until he frees those resources
	 * @param forceQuit = If the system is crashing this variable must be true
	 */
	public void quitProgram(boolean forceQuit) {
		if (isOnTheRoad && !forceQuit) {
			System.out.println("Please Leave the road first");
			return;
		}

		if(forceQuit){
			if(isOnTheRoad)leaveAccessPoint();
		}
	}

	/**
	 * This method is used to communicate with the server the intention of entering the road trough an access point
	 */
	public void enterAccessPoint() {
		System.out.println("What point are you entering at ?(number 1..5)");
		int entryPoint = scan.nextInt();

		Initial initialMsg = Initial.newBuilder().setId(plate).setInPoint(entryPoint).build();

		GenericObserver<Void> pointObserver = new GenericObserver<>("Entering access point");

		controlServiceStub.enter(initialMsg, pointObserver);

		managedWait(pointObserver::isFinished);

		//In case of the server throwing an error, it stays as it was
		if (!pointObserver.wasError()) {
			isOnTheRoad = true;
		}
	}

	/**
	 * This method is used to communicate with the server the intention of leaving the road trough an access point
	 */
	public void leaveAccessPoint() {
		System.out.println("What point are you leaving at ?(number 1..5)");
		int exitPoint = scan.nextInt();

		GenericObserver<Payment> pointObserver = new GenericObserver<>("Exiting access point");

		FinalPoint finalPoint = FinalPoint.newBuilder().setId(plate).setOutPoint(exitPoint).build();

		controlServiceStub.leave(finalPoint, pointObserver);

		managedWait(pointObserver::isFinished);

		//In case of the server throwing an error, it stays as it was
		if (!pointObserver.wasError()) {
			isOnTheRoad = false;
		}

		//If the user was using the warning service, it must log out of it
		if (warningObs != null) {
			warningObs.onCompleted();
		}
	}

	/**
	 * This method is used to allow users to communicate between each other to warn about dangers, or other informations
	 * while being on our roads
	 */
	public void sendWarning() {

		if (!isOnTheRoad) {
			System.out.println("You can only use this service if you are on our roads)");
			return;
		}

		//Initializing the warning observer if the user has not used it yet
		if(warningObs == null) {
			WarningServiceObserver warningServiceObserver = new WarningServiceObserver();

			this.warningObs = controlServiceStub.warning(warningServiceObserver);

			managedWait(() -> warningServiceObserver.getKeyId()!=null);

			warningObs.onNext(WarnMsg.newBuilder().setId(plate).setWarning(warningServiceObserver.getKeyId()).build());
			scan.nextLine();

			//The user in the first call, might only want to sign up to receive warnings
			System.out.println("Do you want to send a warning to the other drivers ? (y/n)");
			String yn = scan.next();
			scan.nextLine(); //Normalizing the line feed
			if(yn.contains("n"))return;

		}
		System.out.println("What warning do you want to send ? ( Animals on the road, a fallen electricity post ...)");
		String reason = scan.nextLine();

		WarnMsg warnMsg = WarnMsg.newBuilder().setId(plate).setWarning(reason).build();
		warningObs.onNext(warnMsg);

	}

	/**
	 * This method allows to do a blocking wait until the parameters turns true, it handles the exceptions and allows
	 * for a cleaner implementation of a blocking wait
	 * @param booleanRunnable - A function that returns the boolean we are waiting to be true
	 */
	private void managedWait(Supplier<Boolean> booleanRunnable){
		while(!booleanRunnable.get()){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
	}

}
