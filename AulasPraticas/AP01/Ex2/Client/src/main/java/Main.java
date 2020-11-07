import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    private static String serverIP = "localhost";
    private static int svcPort = 7000;
    private static String registryName = "RemServer";

    static final String QUIT_WORD = "EXIT", NUMBER = "num";

    public static void main(String[] args) {
        try {
           /* if (args.length == 0 || args.length > 2 || args[0].contentEquals("info")) {
                System.out.println("Please call the program with the following arguments: #serverIP #serverPort");
                System.exit(-1);
            }
            serverIP = args[0];
            if (args.length == 1) {
                System.out.println("It will be used the default port:" + svcPort);
            } else {
                svcPort = Integer.parseInt(args[1]);
            }*/

            // lookup RMI server in registry
            Registry registry = LocateRegistry.getRegistry(serverIP, svcPort);
            ILeiloes svc = (ILeiloes) registry.lookup(registryName);

            LeilaoOperations.initLeilao(svc);
            svc.getAllLeiloes();

        } catch (RemoteException | NotBoundException e) {
            e.getCause();
        }

            /*LeilaoOperations leilaoOperations = new LeilaoOperations();

            MenuInterface userInterface = new MenuInterface();
            addMenuEntries(userInterface);

            while (true) {
                try {
                    userInterface.printAndGetRunnable().run();
                } catch (Exception ex) {
                    System.out.println("Error executing operations!");
                    ex.printStackTrace();
                }
            }

        } catch (IOException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    private static void addMenuEntries(MenuInterface menu) {
        menu.addMenuObject(" : Listar todos os leiloes possiveis de aceder", LeilaoOperations::getAllLeiloes);
        // .addMenuObject(" : Licitar num leilao", LeilaoOperations::licitar)
        // .addMenuObject(" : Delete a VM instance", MenuOperations::deleteVM);

    }
*/
    }
}
