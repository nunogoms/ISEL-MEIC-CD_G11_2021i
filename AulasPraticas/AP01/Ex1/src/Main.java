import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {

    private static final int MAX_PEARLS = 3;

    public static void main(String[] args) {

        RMIClient client = new RMIClient();

        try {
            client.connectToServer();
        } catch (RemoteException | NotBoundException e) {
            e.getCause();
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Insert player id: ");

        int id = input.nextInt();
        System.out.println();
        int foundPearls = 0;

        int x;
        int y;

        while (foundPearls < MAX_PEARLS) {

            System.out.print("Insert first position to search: ");
            x = input.nextInt();
            System.out.println();
            System.out.print("Insert second position to search: ");
            y = input.nextInt();
            System.out.println();

            try {
                if (client.placeBet(id, x, y)) {
                    ++foundPearls;
                }

            } catch (RemoteException e) {
                System.out.println("A error happened:" + e.getMessage());
            }
        }
        System.out.println("Game is finished, all pearls have been found!");
    }
}