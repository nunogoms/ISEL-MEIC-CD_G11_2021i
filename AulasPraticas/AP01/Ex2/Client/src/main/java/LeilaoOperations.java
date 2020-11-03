import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Scanner;

public class LeilaoOperations {
    private static Scanner scanner = new Scanner(System.in);
    private static HashMap<String, SomeObject> notificationsMap = new HashMap<>();

    public static void getAllLeiloes() {

    }

    static void licitar(String Id, ILeiloes svc) throws RemoteException {

    }

    static void initLeilao(ILeiloes svc) throws RemoteException {
        System.out.println("Qual é a descricao do produto ?");
        String descricao = scanner.nextLine();
        System.out.println("Qual é o preco do produto ?");
        Float preco = scanner.nextFloat();

        String id = descricao + Math.random();
        SomeObject someObject = new SomeObject(id, descricao, preco);
        Notifications notifications = new Notifications();

        UnicastRemoteObject.exportObject(notifications, 0);
        svc.initLeilao(someObject, notifications);
    }
}
