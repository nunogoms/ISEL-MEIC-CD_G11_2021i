import centralstubs.CentralServiceGrpc;
import centralstubs.Tariff;
import centralstubs.Track;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import rpcstubs.*;
import rpcstubs.Void;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Server extends ControlServiceGrpc.ControlServiceImplBase {

    private static final String SVC_IP = "35.230.146.225";
    private static final int REGISTER_PORT = 7000;
    private static final int SVC_PORT = 7500;
    private static final int GROUP_ID = 25;
    private static CentralServiceGrpc.CentralServiceBlockingStub blockStub;
    private static Map<String, Integer> trips = new HashMap<>();

    public static void main(String[] args) {

        try {
            ManagedChannel channel = ManagedChannelBuilder.forAddress(SVC_IP, SVC_PORT).usePlaintext().build();
            blockStub = CentralServiceGrpc.newBlockingStub(channel);

            io.grpc.Server server = ServerBuilder.forPort(REGISTER_PORT).addService(new Server()).build();
            server.start();

            Scanner scan = new Scanner(System.in);
            scan.nextLine();

        } catch (IOException exception) {
            exception.getMessage();
            exception.printStackTrace();
        }
    }

    @Override
    public void enter(Initial request, StreamObserver<Void> responseObserver) {

        try {

            int inPoint = request.getInPoint();
            String id = request.getId();

            trips.put(id, inPoint);

            //Only need to signal that the operation was successfully completed
            responseObserver.onCompleted();

        } catch (Throwable throwable) {
            responseObserver.onError(throwable);
        }
    }

    @Override
    public StreamObserver<WarnMsg> warning(StreamObserver<WarnMsg> responseObserver) {

        try {
            
        } catch (Throwable throwable) {
            responseObserver.onError(throwable);
        }

        return null;
    }

    @Override
    public void leave(FinalPoint request, StreamObserver<Payment> responseObserver) {

        try {

            int outpoint = request.getOutPoint();
            String id = request.getId();

            Track track = Track.newBuilder().setInPoint(trips.get(id)).setOutPoint(outpoint).setGroup(GROUP_ID).build();
            Tariff tariff = blockStub.payment(track);
            Payment payment = Payment.newBuilder().setValue(tariff.getValue()).build();

            responseObserver.onNext(payment);
            responseObserver.onCompleted();

            trips.remove(id);

        } catch (Throwable throwable) {
            responseObserver.onError(throwable);
        }
    }
}