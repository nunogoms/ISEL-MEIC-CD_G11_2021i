public class Notifications implements INotification {

    @Override
    public void sendNotification(String s) {
        System.out.println("\nA notification has arrived with the following information :\n" + s + "\n");
    }
}
