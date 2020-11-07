import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Main {
    private static final String SERVER_IP = "localhost";
    private static final int SVC_PORT = 7000;
    private static final Scanner INPUT = new Scanner(System.in);
    private static final String REGISTRY_NAME = "RemServer";

    public static void main(String[] args) {
        try {

            // lookup RMI server in registry
            Registry registry = LocateRegistry.getRegistry(SERVER_IP, SVC_PORT);
            ILeiloes svc = (ILeiloes) registry.lookup(REGISTRY_NAME);

            int choice;

            while (true) {
                System.out.println("Selecionar uma das seguintes opções: ");
                System.out.println("1 - Obter todos os leiloes disponiveis");
                System.out.println("2 - Licitar em um leilao");
                System.out.println("3 - Criar um leilao");

                choice = INPUT.nextInt();

                switch (choice) {

                    case 1:
                        LeilaoOperations.getAllLeiloes(svc);
                        break;

                    case 2: {

                        System.out.println("Insira o ID do leilao ao qual deseja licitar: ");
                        INPUT.nextLine();
                        String id = INPUT.nextLine();
                        LeilaoOperations.licitar(id, svc);
                        break;
                    }

                    case 3:
                        LeilaoOperations.initLeilao(svc);
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Ocorreu um erro na operação selecionada! " + e.getCause());
        }
    }
}
