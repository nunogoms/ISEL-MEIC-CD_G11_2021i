import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILeiloes extends Remote {
    String initLeilao(SomeObject objLei, INotification cb) throws RemoteException;
    SomeObject[] getAllLeiloes() throws RemoteException;
    void licitar(String id, INotification cb) throws RemoteException;
}
