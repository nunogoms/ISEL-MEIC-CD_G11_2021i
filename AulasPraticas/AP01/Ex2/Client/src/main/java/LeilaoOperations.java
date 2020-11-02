import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Scanner;

public class LeilaoOperations {
    public static ILeiloes ILeilao;
    private static Scanner scanner = new Scanner(System.in);
    private static HashMap<String, SomeObject> notificationsMap = new HashMap<>();

    public static void getAllLeiloes() {

    }

    static void licitar(String Id, INotification cb) throws RemoteException {

    }

    static void initLeilao() throws RemoteException {
        System.out.println("Qual é a descricao do produto ?");
        String descricao = scanner.nextLine();
        System.out.println("Qual é o preco do produto ?");
        Float preco = scanner.nextFloat();

        String id = descricao + Math.random();
        SomeObject someObject = new SomeObject(id, descricao, preco);

        INotification notification = new INotification() {
            @Override
            public void sendNotification(String s) throws RemoteException {
                System.out.println("\nA notification has arrived with the following information :\n" + s + "\n");
            }
        };



        UnicastRemoteObject.exportObject(notification, 0);

        ILeilao.initLeilao(someObject, notification);

    }

}
