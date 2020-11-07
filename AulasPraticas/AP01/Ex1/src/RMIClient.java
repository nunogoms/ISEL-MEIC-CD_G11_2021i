import playgamecontract.Bet;
import playgamecontract.IPlayGame;
import playgamecontract.Reply;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

    private final static String serverIP = "35.230.146.225";
    private final static int serverPort = 7000;
    private final static String LOOKUP_NAME = "GameServer";
    private static IPlayGame svc;

    public void connectToServer() throws RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry(serverIP, serverPort);
        svc = (IPlayGame) registry.lookup(LOOKUP_NAME);
    }

    public boolean placeBet(int id, int x, int y) throws RemoteException {

        Bet bet = new Bet(id, x, y);
        Reply reply = svc.playGame(bet);

        System.out.println("Number of plays - " + reply.getNtries());
        System.out.println("Thing equals to - " + reply.getThing());
        System.out.println("Is successful? - " + reply.isSuccess());

        return reply.isSuccess();
    }
}
