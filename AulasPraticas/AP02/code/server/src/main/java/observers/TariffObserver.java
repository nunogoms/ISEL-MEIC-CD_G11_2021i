package observers;

import centralstubs.Tariff;
import io.grpc.stub.StreamObserver;

public class TariffObserver implements StreamObserver<Tariff> {

	public void onNext(Tariff tariff) {

	}

	public void onError(Throwable throwable) {

	}

	public void onCompleted() {

	}
}
