import centralstubs.CentralServiceContract;
import centralstubs.CentralServiceGrpc;
import centralstubs.Tariff;
import centralstubs.Track;
import io.grpc.stub.StreamObserver;

public class Server extends CentralServiceGrpc.CentralServiceImplBase {


	@Override
	public void payment(Track request, StreamObserver<Tariff> responseObserver) {
		super.payment(request, responseObserver);
		//IMplementar non blocking ? yah probably que podem haver n clientes a efetuar pedidos ao mesmo tempo
		// probably multi threaded server ?
	}
}
