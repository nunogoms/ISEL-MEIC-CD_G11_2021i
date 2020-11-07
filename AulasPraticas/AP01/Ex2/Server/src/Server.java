import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class Server implements ILeiloes{

    private static final String serverIP = "localhost";
    private static final int registerPort = 7000;
    private static final int svcPort = 7001;

    private static HashMap<String, Pair> leiloes;

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
        leiloes.put(objLei.id, new Pair(objLei.getDescription(), objLei.value));
        cb.sendNotification("Leilao iniciado com sucesso!");
    }

    @Override
    public SomeObject[] getAllLeiloes() {

        List<SomeObject> allLeiloes = new LinkedList<>();

        for(String key : leiloes.keySet()) {
            allLeiloes.add(new SomeObject(key, leiloes.get(key).getDescription(), leiloes.get(key).getValue()));
        }

        return (SomeObject[]) allLeiloes.toArray();
    }

    @Override
    public void licitar(String id, float value, INotification cb) throws RemoteException {

        leiloes.get(id).setValue(value);
        cb.sendNotification("Licitacao guardada com sucesso!");
    }

    static class Pair {

        private String description;
        private float value;

        public Pair(String description, Float value) {

            this.setValue(value);
            this.setDescription(description);
        }

        public float getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setValue(float value) {
            this.value = value;
        }
    }
}