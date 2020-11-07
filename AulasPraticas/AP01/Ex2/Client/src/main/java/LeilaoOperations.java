import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.stream.Stream;

public class LeilaoOperations {
    private static Scanner scanner = new Scanner(System.in);

    public static void getAllLeiloes(ILeiloes svc) {

        System.out.println("Carregando todos os leiloes...\n");

        try {
            SomeObject[] allLeiloes = svc.getAllLeiloes();
            Stream.of(allLeiloes).forEach((leilao) -> {
                System.out.println("    Leilao : #" + leilao.id);
                System.out.println("    Valor : " + leilao.value);
                System.out.println("    Descricao : " + leilao.description);
                System.out.println();
            });

        } catch (RemoteException e) {
            System.out.println("Não foi possivel encontrar os leiloes devido a erro :\n" + e);
        }
    }

    static void licitar(String id, ILeiloes svc) throws RemoteException {

        System.out.println("Valor a licitar?");
        float value = scanner.nextFloat();

        Notifications notification = new Notifications();
        UnicastRemoteObject.exportObject(notification, 0);
        svc.licitar(id, value, notification);
    }

    static void initLeilao(ILeiloes svc) throws RemoteException {
        System.out.println("Qual é a descricao do produto ?");
        String descricao = scanner.nextLine();
        System.out.println("Qual é o preco do produto ?");
        float preco = scanner.nextFloat();

        String id = descricao + Math.random();
        SomeObject someObject = new SomeObject(id, descricao, preco);
        Notifications notifications = new Notifications();

        UnicastRemoteObject.exportObject(notifications, 0);
        svc.initLeilao(someObject, notifications);
    }
}