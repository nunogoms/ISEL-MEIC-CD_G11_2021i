import centralstubs.CentralServiceGrpc;
import centralstubs.Tariff;
import centralstubs.Track;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import observers.TariffObserver;

public class Server {
	static String svcIP = "35.230.146.225"; //cmd
	static int svcPort = 7500; //cmd
	static int groupID = 25;

	public static void main(String[] args) {
		//TODO add static logger
		try {
			ManagedChannel channel = ManagedChannelBuilder.forAddress(svcIP, svcPort).usePlaintext().build();

			//            // call find primes
			CentralServiceGrpc.CentralServiceBlockingStub blockStub = CentralServiceGrpc.newBlockingStub(channel);

			Track build = Track.newBuilder().setInPoint(1).setOutPoint(4).setGroup(groupID).build();

			Tariff payment = blockStub.payment(build);

			System.out.println();


			/*
			PrimesObserver primesObserver = new PrimesObserver();
			blockStub.findPrimes(
					SerieOfPrimes.newBuilder()
							.setNumberOfPrimes(500)
							.setStartNumber(1).build(),
					primesObserver);


			while (!primesObserver.isCompleted()) {

				System.out.println("doing something");
				Thread.sleep(2000);

			}

			System.out.println("press enter to exit");
			Scanner scan=new Scanner(System.in); scan.nextLine();
			*/
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
