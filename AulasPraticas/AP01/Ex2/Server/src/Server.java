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
            printError(e);
        }
    }

    @Override
    public void initLeilao(SomeObject objLei, INotification cb) throws RemoteException {
        // Faz-se um id para cada leilao para facilitar encontrar cada um deles. Nao e tido em conta
        // quando sao removidos leiloes
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

        /**
         * Itera por todos os leiloes e encontra o que o cliente pediu, e manda notificacao caso esteja errada ou correta
         */
        Optional<SomeObject> leilao = leiloes.values()
                .stream()
                .filter(someObject -> someObject.getId().equals(id))
                .findFirst();

        try {
            if (leilao.isPresent()) {
                leilao.get().setValue(value);
                cb.sendNotification("Licitacao guardada com sucesso!");

            } else {
                //Manda erro para o cliente caso não seja encontradp o leilao
                cb.sendNotification("Leilao com id " + id + " nao encontrado!");
            }

        } catch (RemoteException e) {
           printError(e);
        }
    }

    private static void printError(Exception e){
        System.out.println("Foi encontrado um erro no servidor :" + e);
    }
}