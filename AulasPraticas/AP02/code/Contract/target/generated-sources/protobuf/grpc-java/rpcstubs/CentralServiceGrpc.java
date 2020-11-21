package rpcstubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.1)",
    comments = "Source: contract.proto")
public final class CentralServiceGrpc {

  private CentralServiceGrpc() {}

  public static final String SERVICE_NAME = "serverImpl.CentralService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<rpcstubs.Contract.Initial,
      rpcstubs.Contract.Void> getEnterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Enter",
      requestType = rpcstubs.Contract.Initial.class,
      responseType = rpcstubs.Contract.Void.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rpcstubs.Contract.Initial,
      rpcstubs.Contract.Void> getEnterMethod() {
    io.grpc.MethodDescriptor<rpcstubs.Contract.Initial, rpcstubs.Contract.Void> getEnterMethod;
    if ((getEnterMethod = CentralServiceGrpc.getEnterMethod) == null) {
      synchronized (CentralServiceGrpc.class) {
        if ((getEnterMethod = CentralServiceGrpc.getEnterMethod) == null) {
          CentralServiceGrpc.getEnterMethod = getEnterMethod =
              io.grpc.MethodDescriptor.<rpcstubs.Contract.Initial, rpcstubs.Contract.Void>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Enter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Contract.Initial.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Contract.Void.getDefaultInstance()))
              .setSchemaDescriptor(new CentralServiceMethodDescriptorSupplier("Enter"))
              .build();
        }
      }
    }
    return getEnterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rpcstubs.Contract.WarnMsg,
      rpcstubs.Contract.WarnMsg> getWarningMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Warning",
      requestType = rpcstubs.Contract.WarnMsg.class,
      responseType = rpcstubs.Contract.WarnMsg.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<rpcstubs.Contract.WarnMsg,
      rpcstubs.Contract.WarnMsg> getWarningMethod() {
    io.grpc.MethodDescriptor<rpcstubs.Contract.WarnMsg, rpcstubs.Contract.WarnMsg> getWarningMethod;
    if ((getWarningMethod = CentralServiceGrpc.getWarningMethod) == null) {
      synchronized (CentralServiceGrpc.class) {
        if ((getWarningMethod = CentralServiceGrpc.getWarningMethod) == null) {
          CentralServiceGrpc.getWarningMethod = getWarningMethod =
              io.grpc.MethodDescriptor.<rpcstubs.Contract.WarnMsg, rpcstubs.Contract.WarnMsg>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Warning"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Contract.WarnMsg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Contract.WarnMsg.getDefaultInstance()))
              .setSchemaDescriptor(new CentralServiceMethodDescriptorSupplier("Warning"))
              .build();
        }
      }
    }
    return getWarningMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rpcstubs.Contract.FinalPoint,
      rpcstubs.Contract.Payment> getLeaveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Leave",
      requestType = rpcstubs.Contract.FinalPoint.class,
      responseType = rpcstubs.Contract.Payment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rpcstubs.Contract.FinalPoint,
      rpcstubs.Contract.Payment> getLeaveMethod() {
    io.grpc.MethodDescriptor<rpcstubs.Contract.FinalPoint, rpcstubs.Contract.Payment> getLeaveMethod;
    if ((getLeaveMethod = CentralServiceGrpc.getLeaveMethod) == null) {
      synchronized (CentralServiceGrpc.class) {
        if ((getLeaveMethod = CentralServiceGrpc.getLeaveMethod) == null) {
          CentralServiceGrpc.getLeaveMethod = getLeaveMethod =
              io.grpc.MethodDescriptor.<rpcstubs.Contract.FinalPoint, rpcstubs.Contract.Payment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Leave"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Contract.FinalPoint.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Contract.Payment.getDefaultInstance()))
              .setSchemaDescriptor(new CentralServiceMethodDescriptorSupplier("Leave"))
              .build();
        }
      }
    }
    return getLeaveMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CentralServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CentralServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CentralServiceStub>() {
        @java.lang.Override
        public CentralServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CentralServiceStub(channel, callOptions);
        }
      };
    return CentralServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CentralServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CentralServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CentralServiceBlockingStub>() {
        @java.lang.Override
        public CentralServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CentralServiceBlockingStub(channel, callOptions);
        }
      };
    return CentralServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CentralServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CentralServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CentralServiceFutureStub>() {
        @java.lang.Override
        public CentralServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CentralServiceFutureStub(channel, callOptions);
        }
      };
    return CentralServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CentralServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Entrar na estrada
     * </pre>
     */
    public void enter(rpcstubs.Contract.Initial request,
        io.grpc.stub.StreamObserver<rpcstubs.Contract.Void> responseObserver) {
      asyncUnimplementedUnaryCall(getEnterMethod(), responseObserver);
    }

    /**
     * <pre>
     * emissão/receção de eventos
     * </pre>
     */
    public io.grpc.stub.StreamObserver<rpcstubs.Contract.WarnMsg> warning(
        io.grpc.stub.StreamObserver<rpcstubs.Contract.WarnMsg> responseObserver) {
      return asyncUnimplementedStreamingCall(getWarningMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sair da estrada
     * </pre>
     */
    public void leave(rpcstubs.Contract.FinalPoint request,
        io.grpc.stub.StreamObserver<rpcstubs.Contract.Payment> responseObserver) {
      asyncUnimplementedUnaryCall(getLeaveMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEnterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rpcstubs.Contract.Initial,
                rpcstubs.Contract.Void>(
                  this, METHODID_ENTER)))
          .addMethod(
            getWarningMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                rpcstubs.Contract.WarnMsg,
                rpcstubs.Contract.WarnMsg>(
                  this, METHODID_WARNING)))
          .addMethod(
            getLeaveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rpcstubs.Contract.FinalPoint,
                rpcstubs.Contract.Payment>(
                  this, METHODID_LEAVE)))
          .build();
    }
  }

  /**
   */
  public static final class CentralServiceStub extends io.grpc.stub.AbstractAsyncStub<CentralServiceStub> {
    private CentralServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CentralServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CentralServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Entrar na estrada
     * </pre>
     */
    public void enter(rpcstubs.Contract.Initial request,
        io.grpc.stub.StreamObserver<rpcstubs.Contract.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEnterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * emissão/receção de eventos
     * </pre>
     */
    public io.grpc.stub.StreamObserver<rpcstubs.Contract.WarnMsg> warning(
        io.grpc.stub.StreamObserver<rpcstubs.Contract.WarnMsg> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getWarningMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Sair da estrada
     * </pre>
     */
    public void leave(rpcstubs.Contract.FinalPoint request,
        io.grpc.stub.StreamObserver<rpcstubs.Contract.Payment> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLeaveMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CentralServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CentralServiceBlockingStub> {
    private CentralServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CentralServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CentralServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Entrar na estrada
     * </pre>
     */
    public rpcstubs.Contract.Void enter(rpcstubs.Contract.Initial request) {
      return blockingUnaryCall(
          getChannel(), getEnterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sair da estrada
     * </pre>
     */
    public rpcstubs.Contract.Payment leave(rpcstubs.Contract.FinalPoint request) {
      return blockingUnaryCall(
          getChannel(), getLeaveMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CentralServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CentralServiceFutureStub> {
    private CentralServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CentralServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CentralServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Entrar na estrada
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<rpcstubs.Contract.Void> enter(
        rpcstubs.Contract.Initial request) {
      return futureUnaryCall(
          getChannel().newCall(getEnterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sair da estrada
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<rpcstubs.Contract.Payment> leave(
        rpcstubs.Contract.FinalPoint request) {
      return futureUnaryCall(
          getChannel().newCall(getLeaveMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ENTER = 0;
  private static final int METHODID_LEAVE = 1;
  private static final int METHODID_WARNING = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CentralServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CentralServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ENTER:
          serviceImpl.enter((rpcstubs.Contract.Initial) request,
              (io.grpc.stub.StreamObserver<rpcstubs.Contract.Void>) responseObserver);
          break;
        case METHODID_LEAVE:
          serviceImpl.leave((rpcstubs.Contract.FinalPoint) request,
              (io.grpc.stub.StreamObserver<rpcstubs.Contract.Payment>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WARNING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.warning(
              (io.grpc.stub.StreamObserver<rpcstubs.Contract.WarnMsg>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CentralServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CentralServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return rpcstubs.Contract.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CentralService");
    }
  }

  private static final class CentralServiceFileDescriptorSupplier
      extends CentralServiceBaseDescriptorSupplier {
    CentralServiceFileDescriptorSupplier() {}
  }

  private static final class CentralServiceMethodDescriptorSupplier
      extends CentralServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CentralServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CentralServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CentralServiceFileDescriptorSupplier())
              .addMethod(getEnterMethod())
              .addMethod(getWarningMethod())
              .addMethod(getLeaveMethod())
              .build();
        }
      }
    }
    return result;
  }
}
