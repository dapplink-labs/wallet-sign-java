package xyz.dapplink.iface.lib;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: wallet.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WalletServiceGrpc {

  private WalletServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "dapplink.wallet.WalletService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<xyz.dapplink.iface.lib.SupportSignWayRequest,
      xyz.dapplink.iface.lib.SupportSignWayResponse> getGetSupportSignWayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getSupportSignWay",
      requestType = xyz.dapplink.iface.lib.SupportSignWayRequest.class,
      responseType = xyz.dapplink.iface.lib.SupportSignWayResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<xyz.dapplink.iface.lib.SupportSignWayRequest,
      xyz.dapplink.iface.lib.SupportSignWayResponse> getGetSupportSignWayMethod() {
    io.grpc.MethodDescriptor<xyz.dapplink.iface.lib.SupportSignWayRequest, xyz.dapplink.iface.lib.SupportSignWayResponse> getGetSupportSignWayMethod;
    if ((getGetSupportSignWayMethod = WalletServiceGrpc.getGetSupportSignWayMethod) == null) {
      synchronized (WalletServiceGrpc.class) {
        if ((getGetSupportSignWayMethod = WalletServiceGrpc.getGetSupportSignWayMethod) == null) {
          WalletServiceGrpc.getGetSupportSignWayMethod = getGetSupportSignWayMethod =
              io.grpc.MethodDescriptor.<xyz.dapplink.iface.lib.SupportSignWayRequest, xyz.dapplink.iface.lib.SupportSignWayResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getSupportSignWay"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xyz.dapplink.iface.lib.SupportSignWayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xyz.dapplink.iface.lib.SupportSignWayResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WalletServiceMethodDescriptorSupplier("getSupportSignWay"))
              .build();
        }
      }
    }
    return getGetSupportSignWayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<xyz.dapplink.iface.lib.ExportPublicKeyRequest,
      xyz.dapplink.iface.lib.ExportPublicKeyResponse> getExportPublicKeyListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "exportPublicKeyList",
      requestType = xyz.dapplink.iface.lib.ExportPublicKeyRequest.class,
      responseType = xyz.dapplink.iface.lib.ExportPublicKeyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<xyz.dapplink.iface.lib.ExportPublicKeyRequest,
      xyz.dapplink.iface.lib.ExportPublicKeyResponse> getExportPublicKeyListMethod() {
    io.grpc.MethodDescriptor<xyz.dapplink.iface.lib.ExportPublicKeyRequest, xyz.dapplink.iface.lib.ExportPublicKeyResponse> getExportPublicKeyListMethod;
    if ((getExportPublicKeyListMethod = WalletServiceGrpc.getExportPublicKeyListMethod) == null) {
      synchronized (WalletServiceGrpc.class) {
        if ((getExportPublicKeyListMethod = WalletServiceGrpc.getExportPublicKeyListMethod) == null) {
          WalletServiceGrpc.getExportPublicKeyListMethod = getExportPublicKeyListMethod =
              io.grpc.MethodDescriptor.<xyz.dapplink.iface.lib.ExportPublicKeyRequest, xyz.dapplink.iface.lib.ExportPublicKeyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "exportPublicKeyList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xyz.dapplink.iface.lib.ExportPublicKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xyz.dapplink.iface.lib.ExportPublicKeyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WalletServiceMethodDescriptorSupplier("exportPublicKeyList"))
              .build();
        }
      }
    }
    return getExportPublicKeyListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<xyz.dapplink.iface.lib.SignTxMessageRequest,
      xyz.dapplink.iface.lib.SignTxMessageResponse> getSignTxMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "signTxMessage",
      requestType = xyz.dapplink.iface.lib.SignTxMessageRequest.class,
      responseType = xyz.dapplink.iface.lib.SignTxMessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<xyz.dapplink.iface.lib.SignTxMessageRequest,
      xyz.dapplink.iface.lib.SignTxMessageResponse> getSignTxMessageMethod() {
    io.grpc.MethodDescriptor<xyz.dapplink.iface.lib.SignTxMessageRequest, xyz.dapplink.iface.lib.SignTxMessageResponse> getSignTxMessageMethod;
    if ((getSignTxMessageMethod = WalletServiceGrpc.getSignTxMessageMethod) == null) {
      synchronized (WalletServiceGrpc.class) {
        if ((getSignTxMessageMethod = WalletServiceGrpc.getSignTxMessageMethod) == null) {
          WalletServiceGrpc.getSignTxMessageMethod = getSignTxMessageMethod =
              io.grpc.MethodDescriptor.<xyz.dapplink.iface.lib.SignTxMessageRequest, xyz.dapplink.iface.lib.SignTxMessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "signTxMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xyz.dapplink.iface.lib.SignTxMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xyz.dapplink.iface.lib.SignTxMessageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WalletServiceMethodDescriptorSupplier("signTxMessage"))
              .build();
        }
      }
    }
    return getSignTxMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WalletServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WalletServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WalletServiceStub>() {
        @java.lang.Override
        public WalletServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WalletServiceStub(channel, callOptions);
        }
      };
    return WalletServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WalletServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WalletServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WalletServiceBlockingStub>() {
        @java.lang.Override
        public WalletServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WalletServiceBlockingStub(channel, callOptions);
        }
      };
    return WalletServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WalletServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WalletServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WalletServiceFutureStub>() {
        @java.lang.Override
        public WalletServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WalletServiceFutureStub(channel, callOptions);
        }
      };
    return WalletServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getSupportSignWay(xyz.dapplink.iface.lib.SupportSignWayRequest request,
        io.grpc.stub.StreamObserver<xyz.dapplink.iface.lib.SupportSignWayResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSupportSignWayMethod(), responseObserver);
    }

    /**
     */
    default void exportPublicKeyList(xyz.dapplink.iface.lib.ExportPublicKeyRequest request,
        io.grpc.stub.StreamObserver<xyz.dapplink.iface.lib.ExportPublicKeyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportPublicKeyListMethod(), responseObserver);
    }

    /**
     */
    default void signTxMessage(xyz.dapplink.iface.lib.SignTxMessageRequest request,
        io.grpc.stub.StreamObserver<xyz.dapplink.iface.lib.SignTxMessageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSignTxMessageMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WalletService.
   */
  public static abstract class WalletServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return WalletServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WalletService.
   */
  public static final class WalletServiceStub
      extends io.grpc.stub.AbstractAsyncStub<WalletServiceStub> {
    private WalletServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WalletServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WalletServiceStub(channel, callOptions);
    }

    /**
     */
    public void getSupportSignWay(xyz.dapplink.iface.lib.SupportSignWayRequest request,
        io.grpc.stub.StreamObserver<xyz.dapplink.iface.lib.SupportSignWayResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSupportSignWayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void exportPublicKeyList(xyz.dapplink.iface.lib.ExportPublicKeyRequest request,
        io.grpc.stub.StreamObserver<xyz.dapplink.iface.lib.ExportPublicKeyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportPublicKeyListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void signTxMessage(xyz.dapplink.iface.lib.SignTxMessageRequest request,
        io.grpc.stub.StreamObserver<xyz.dapplink.iface.lib.SignTxMessageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSignTxMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WalletService.
   */
  public static final class WalletServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WalletServiceBlockingStub> {
    private WalletServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WalletServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WalletServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public xyz.dapplink.iface.lib.SupportSignWayResponse getSupportSignWay(xyz.dapplink.iface.lib.SupportSignWayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSupportSignWayMethod(), getCallOptions(), request);
    }

    /**
     */
    public xyz.dapplink.iface.lib.ExportPublicKeyResponse exportPublicKeyList(xyz.dapplink.iface.lib.ExportPublicKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportPublicKeyListMethod(), getCallOptions(), request);
    }

    /**
     */
    public xyz.dapplink.iface.lib.SignTxMessageResponse signTxMessage(xyz.dapplink.iface.lib.SignTxMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSignTxMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WalletService.
   */
  public static final class WalletServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<WalletServiceFutureStub> {
    private WalletServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WalletServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WalletServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<xyz.dapplink.iface.lib.SupportSignWayResponse> getSupportSignWay(
        xyz.dapplink.iface.lib.SupportSignWayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSupportSignWayMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<xyz.dapplink.iface.lib.ExportPublicKeyResponse> exportPublicKeyList(
        xyz.dapplink.iface.lib.ExportPublicKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportPublicKeyListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<xyz.dapplink.iface.lib.SignTxMessageResponse> signTxMessage(
        xyz.dapplink.iface.lib.SignTxMessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSignTxMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SUPPORT_SIGN_WAY = 0;
  private static final int METHODID_EXPORT_PUBLIC_KEY_LIST = 1;
  private static final int METHODID_SIGN_TX_MESSAGE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SUPPORT_SIGN_WAY:
          serviceImpl.getSupportSignWay((xyz.dapplink.iface.lib.SupportSignWayRequest) request,
              (io.grpc.stub.StreamObserver<xyz.dapplink.iface.lib.SupportSignWayResponse>) responseObserver);
          break;
        case METHODID_EXPORT_PUBLIC_KEY_LIST:
          serviceImpl.exportPublicKeyList((xyz.dapplink.iface.lib.ExportPublicKeyRequest) request,
              (io.grpc.stub.StreamObserver<xyz.dapplink.iface.lib.ExportPublicKeyResponse>) responseObserver);
          break;
        case METHODID_SIGN_TX_MESSAGE:
          serviceImpl.signTxMessage((xyz.dapplink.iface.lib.SignTxMessageRequest) request,
              (io.grpc.stub.StreamObserver<xyz.dapplink.iface.lib.SignTxMessageResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetSupportSignWayMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              xyz.dapplink.iface.lib.SupportSignWayRequest,
              xyz.dapplink.iface.lib.SupportSignWayResponse>(
                service, METHODID_GET_SUPPORT_SIGN_WAY)))
        .addMethod(
          getExportPublicKeyListMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              xyz.dapplink.iface.lib.ExportPublicKeyRequest,
              xyz.dapplink.iface.lib.ExportPublicKeyResponse>(
                service, METHODID_EXPORT_PUBLIC_KEY_LIST)))
        .addMethod(
          getSignTxMessageMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              xyz.dapplink.iface.lib.SignTxMessageRequest,
              xyz.dapplink.iface.lib.SignTxMessageResponse>(
                service, METHODID_SIGN_TX_MESSAGE)))
        .build();
  }

  private static abstract class WalletServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WalletServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return xyz.dapplink.iface.lib.WalletProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WalletService");
    }
  }

  private static final class WalletServiceFileDescriptorSupplier
      extends WalletServiceBaseDescriptorSupplier {
    WalletServiceFileDescriptorSupplier() {}
  }

  private static final class WalletServiceMethodDescriptorSupplier
      extends WalletServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WalletServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (WalletServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WalletServiceFileDescriptorSupplier())
              .addMethod(getGetSupportSignWayMethod())
              .addMethod(getExportPublicKeyListMethod())
              .addMethod(getSignTxMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
