import io.grpc.stub.StreamObserver;
import observers.GenericObserver;
import observers.WarningServiceObserver;
import rpcstubs.Void;
import rpcstubs.*;

import java.util.Scanner;

public class Operations {
	private final Scanner scan = new Scanner(System.in);

	private final ControlServiceGrpc.ControlServiceStub controlServiceStub;
	private final String matricula;

	private boolean isOnTheRoad = true;
	private StreamObserver<WarnMsg> warningObs;

	public Operations(ControlServiceGrpc.ControlServiceStub controlServiceStub, String matricula) {
		this.controlServiceStub = controlServiceStub;
		this.matricula = matricula;
	}

	public void quitProgram(boolean forceQuit) {
		if (isOnTheRoad && !forceQuit) {
			System.out.println("Please Leave the road first");
			return;
		}

		if(forceQuit){
			if(isOnTheRoad)leaveAccessPoint();

		}

	}

	public void enterAccessPoint() {
		System.out.println("What point are you entering at ?(number 1..5)");
		int entryPoint = scan.nextInt();

		Initial initialMsg = Initial.newBuilder().setId(matricula).setInPoint(entryPoint).build();

		GenericObserver<Void> pointObserver = new GenericObserver<>("Entering access point");

		controlServiceStub.enter(initialMsg, pointObserver);

		managedWait(pointObserver);

		if (!pointObserver.wasError()) {
			isOnTheRoad = true;

			WarningServiceObserver warningServiceObserver = new WarningServiceObserver();

			this.warningObs = controlServiceStub.warning(warningServiceObserver);
			warningObs.onNext(WarnMsg.newBuilder().setId(matricula).setWarning(warningServiceObserver.getKeyId()).build());
		}
	}

	public void leaveAccessPoint() {
		System.out.println("What point are you leaving at ?(number 1..5)");
		int exitPoint = scan.nextInt();

		GenericObserver<Payment> pointObserver = new GenericObserver<>("Exiting access point");

		FinalPoint finalPoint = FinalPoint.newBuilder().setId(matricula).setOutPoint(exitPoint).build();

		controlServiceStub.leave(finalPoint, pointObserver);

		managedWait(pointObserver);

		if (!pointObserver.wasError()) {
			isOnTheRoad = false;
		}

		if (warningObs != null) {
			warningObs.onCompleted();
		}
	}

	public void sendWarning() {
		if (!isOnTheRoad) {
			System.out.println("You can only use this service if you are on our roads)");
			return;
		}

		System.out.println("What warning do you want to send ? ( Animals on the road, a fallen electricity post ...)");
		String reason = scan.nextLine();

		WarnMsg warnMsg = WarnMsg.newBuilder().setId(matricula).setWarning(reason).build();
		warningObs.onNext(warnMsg);

	}

	private void managedWait(GenericObserver observer){
		while(!observer.isFinished()){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
	}

}
