import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.stream.Stream;

public class LeilaoOperations {
    private static Scanner scanner = new Scanner(System.in);
    private static final int EXPORT_OBJECT_PORT = 0;

    public static void getAllLeiloes(ILeiloes svc) throws RemoteException {

        System.out.println("Carregando todos os leiloes...\n");

        SomeObject[] allLeiloes = svc.getAllLeiloes();

        Stream.of(allLeiloes).forEach((leilao) -> {
            System.out.println("    Leilao : #" + leilao.id);
            System.out.println("    Valor : " + leilao.value);
            System.out.println("    Descricao : " + leilao.description);
            System.out.println();
        });
    }

    static void licitar(String id, ILeiloes svc) throws RemoteException {

        System.out.println("Valor a licitar?");
        float value = scanner.nextFloat();

        Notifications notification = new Notifications();
        UnicastRemoteObject.exportObject(notification, EXPORT_OBJECT_PORT);
        svc.licitar(id, value, notification);
    }

    static void initLeilao(ILeiloes svc) throws RemoteException {
        System.out.println("Qual é a descricao do produto ?");
        scanner.nextLine();
        String descricao = scanner.nextLine();
        System.out.println("Qual é o preco do produto ?");
        float preco = scanner.nextFloat();

        String id = descricao + Math.random();
        SomeObject someObject = new SomeObject(id, descricao, preco);
        Notifications notifications = new Notifications();

        UnicastRemoteObject.exportObject(notifications, EXPORT_OBJECT_PORT);
        svc.initLeilao(someObject, notifications);
    }
}