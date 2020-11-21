import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import rpcstubs.ControlServiceGrpc;
import ui.MenuInterface;

import java.util.Scanner;

public class Client {
	static String svcIP="35.230.146.225";
	static int svcPort=6000;

	private static final MenuInterface userInterface = new MenuInterface();
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Operations operations = null;
		try {
			ManagedChannel channel = ManagedChannelBuilder.forAddress(svcIP, svcPort).usePlaintext().build();
			// call pingServer

			ControlServiceGrpc.ControlServiceStub controlServiceStub = ControlServiceGrpc.newStub(channel);

			System.out.println("What is your car matricula ?");
			String matricula = scan.next();

			operations = new Operations(controlServiceStub, matricula);
			addMenuEntries(userInterface, operations);

			try {

				while (!MenuInterface.isShuttingDown) {
					try {
						userInterface.printAndGetRunnable().run();
					} catch (Exception ex) {
						System.out.println("Error executing operations!");
						ex.printStackTrace();
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}finally {
			if(operations!=null)operations.quitProgram(true);
		}
	}

	private static void addMenuEntries(MenuInterface menu, Operations operations) {
		menu.addMenuObject(" : Enter Access Point", operations::enterAccessPoint)
				.addMenuObject(" : Leave Access Point", operations::leaveAccessPoint)
				.addMenuObject(" : Send a warning", operations::sendWarning)
				.addMenuObject(" : Quit Program", () -> operations.quitProgram(false));
	}

}
