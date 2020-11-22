import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import rpcstubs.ControlServiceGrpc;
import ui.MenuInterface;

import java.util.Scanner;

public class Client {

    static String svcIP = "localhost";
    static int svcPort = 7000;

    //This variable is used only to provide the user with a navigable UI
    private static final MenuInterface userInterface = new MenuInterface();
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Operations operations = null;
        try {
            //Conection to the server
            ManagedChannel channel = ManagedChannelBuilder.forAddress(svcIP, svcPort).usePlaintext().build();
            ControlServiceGrpc.ControlServiceStub controlServiceStub = ControlServiceGrpc.newStub(channel);

            System.out.println("What is your car plate ?");
            String plate = scan.next();

            //Instance of the operations class
            operations = new Operations(controlServiceStub, plate);
            addMenuEntries(operations);

            try {
                /**
                 * Loop for the program to work and also try and close all the used resources on the server
                 */
                while (!MenuInterface.isShuttingDown) {
                    try {
                        userInterface.printAndGetRunnable().run();
                    } catch (Exception ex) {
                        System.out.println("Error executing operations!");
                        System.out.println(ex.getMessage());
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } finally {
            //Here we try to close the resources being used in the server
            if (operations != null) operations.quitProgram(true);
        }
    }

    //Only used to setup the UI menu
    private static void addMenuEntries(Operations operations) {
        Client.userInterface.addMenuObject(" : Enter Access Point", operations::enterAccessPoint)
                .addMenuObject(" : Leave Access Point", operations::leaveAccessPoint)
                .addMenuObject(" : Send a warning", operations::sendWarning)
                .addQuitEntry( () -> operations.quitProgram(false));
    }

}
