import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;

public class Server implements ILeiloes{

    private static final String serverIP = "localhost";
    private static final int registerPort = 7000;
    private static final int svcPort = 7001;

    public static void main(String[] args) {

        try {

            Properties props = System.getProperties();
            props.put("java.rmi.server.hostname", serverIP);

            Server svc = new Server();
            ILeiloes stubSvc = (ILeiloes) UnicastRemoteObject.exportObject(svc, svcPort);
            Registry registry = LocateRegistry.createRegistry(registerPort);
            registry.rebind("RemServer", stubSvc);

        } catch (RemoteException e) {
            e.getCause();
        }
    }

    @Override
    public void initLeilao(SomeObject objLei, INotification cb) throws RemoteException {
        cb.sendNotification("CONA!");
    }

    @Override
    public SomeObject[] getAllLeiloes() throws RemoteException {
        return new SomeObject[0];
    }

    @Override
    public void licitar(String id, float value, INotification cb) throws RemoteException {
        cb.sendNotification("CONA!");
    }
}
