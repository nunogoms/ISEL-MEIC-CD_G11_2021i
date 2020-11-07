import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Server implements ILeiloes {

    private static final String serverIP = "localhost";
    private static final int registerPort = 7000;
    private static final int svcPort = 7001;

    private static HashMap<Integer, SomeObject> leiloes;
    private static Integer counter = 1;

    public static void main(String[] args) {

        try {

            Properties props = System.getProperties();
            props.put("java.rmi.server.hostname", serverIP);

            Server svc = new Server();
            ILeiloes stubSvc = (ILeiloes) UnicastRemoteObject.exportObject(svc, svcPort);
            Registry registry = LocateRegistry.createRegistry(registerPort);
            registry.rebind("RemServer", stubSvc);

            leiloes = new HashMap<>();

        } catch (RemoteException e) {
            e.getCause();
        }
    }

    @Override
    public void initLeilao(SomeObject objLei, INotification cb) throws RemoteException {
        leiloes.put(counter++, objLei);
        cb.sendNotification("Leilao iniciado com sucesso!");
    }

    @Override
    public SomeObject[] getAllLeiloes() {

        List<SomeObject> allLeiloes = new LinkedList<>(leiloes.values());
        return allLeiloes.toArray(new SomeObject[0]);
    }

    @Override
    public void licitar(String id, float value, INotification cb) throws RemoteException {

        //COMEÇEM A REZAR QUANDO CHEGAR AQUI!
        leiloes.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getId().equals(id))
                .findFirst()
                .ifPresentOrElse(obj -> obj.getValue().setValue(value), () -> {

                    try {
                        cb.sendNotification("Leilao com id " + id + " nao encontrado!");

                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                });

        cb.sendNotification("Licitacao guardada com sucesso!");
    }
}