import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILeiloes extends Remote {
    void initLeilao(SomeObject objLei, INotification cb) throws RemoteException;
    SomeObject[] getAllLeiloes() throws RemoteException;
    void licitar(String id, float value, INotification cb) throws RemoteException;
}
