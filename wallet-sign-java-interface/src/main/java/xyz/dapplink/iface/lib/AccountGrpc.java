package xyz.dapplink.iface.lib;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: account.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AccountGrpc {

  private AccountGrpc() {}

  public static final java.lang.String SERVICE_NAME = "Account";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<xyz.dapplink.iface.lib.GenerateKeygenRequest,
      xyz.dapplink.iface.lib.GenerateKeygenResponse> getGenerateKeygenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateKeygen",
      requestType = xyz.dapplink.iface.lib.GenerateKeygenRequest.class,
      responseType = xyz.dapplink.iface.lib.GenerateKeygenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<xyz.dapplink.iface.lib.GenerateKeygenRequest,
      xyz.dapplink.iface.lib.GenerateKeygenResponse> getGenerateKeygenMethod() {
    io.grpc.MethodDescriptor<xyz.dapplink.iface.lib.GenerateKeygenRequest, xyz.dapplink.iface.lib.GenerateKeygenResponse> getGenerateKeygenMethod;
    if ((getGenerateKeygenMethod = AccountGrpc.getGenerateKeygenMethod) == null) {
      synchronized (AccountGrpc.class) {
        if ((getGenerateKeygenMethod = AccountGrpc.getGenerateKeygenMethod) == null) {
          AccountGrpc.getGenerateKeygenMethod = getGenerateKeygenMethod =
              io.grpc.MethodDescriptor.<xyz.dapplink.iface.lib.GenerateKeygenRequest, xyz.dapplink.iface.lib.GenerateKeygenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateKeygen"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xyz.dapplink.iface.lib.GenerateKeygenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xyz.dapplink.iface.lib.GenerateKeygenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccountMethodDescriptorSupplier("GenerateKeygen"))
              .build();
        }
      }
    }
    return getGenerateKeygenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<xyz.dapplink.iface.lib.GenerateSignatureRequest,
      xyz.dapplink.iface.lib.GenerateSignatureResponse> getGenerateSignatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateSignature",
      requestType = xyz.dapplink.iface.lib.GenerateSignatureRequest.class,
      responseType = xyz.dapplink.iface.lib.GenerateSignatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<xyz.dapplink.iface.lib.GenerateSignatureRequest,
      xyz.dapplink.iface.lib.GenerateSignatureResponse> getGenerateSignatureMethod() {
    io.grpc.MethodDescriptor<xyz.dapplink.iface.lib.GenerateSignatureRequest, xyz.dapplink.iface.lib.GenerateSignatureResponse> getGenerateSignatureMethod;
    if ((getGenerateSignatureMethod = AccountGrpc.getGenerateSignatureMethod) == null) {
      synchronized (AccountGrpc.class) {
        if ((getGenerateSignatureMethod = AccountGrpc.getGenerateSignatureMethod) == null) {
          AccountGrpc.getGenerateSignatureMethod = getGenerateSignatureMethod =
              io.grpc.MethodDescriptor.<xyz.dapplink.iface.lib.GenerateSignatureRequest, xyz.dapplink.iface.lib.GenerateSignatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateSignature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xyz.dapplink.iface.lib.GenerateSignatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xyz.dapplink.iface.lib.GenerateSignatureResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccountMethodDescriptorSupplier("GenerateSignature"))
              .build();
        }
      }
    }
    return getGenerateSignatureMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AccountStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountStub>() {
        @java.lang.Override
        public AccountStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountStub(channel, callOptions);
        }
      };
    return AccountStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountBlockingStub>() {
        @java.lang.Override
        public AccountBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountBlockingStub(channel, callOptions);
        }
      };
    return AccountBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AccountFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountFutureStub>() {
        @java.lang.Override
        public AccountFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountFutureStub(channel, callOptions);
        }
      };
    return AccountFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void generateKeygen(xyz.dapplink.iface.lib.GenerateKeygenRequest request,
        io.grpc.stub.StreamObserver<xyz.dapplink.iface.lib.GenerateKeygenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateKeygenMethod(), responseObserver);
    }

    /**
     */
    default void generateSignature(xyz.dapplink.iface.lib.GenerateSignatureRequest request,
        io.grpc.stub.StreamObserver<xyz.dapplink.iface.lib.GenerateSignatureResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateSignatureMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Account.
   */
  public static abstract class AccountImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AccountGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Account.
   */
  public static final class AccountStub
      extends io.grpc.stub.AbstractAsyncStub<AccountStub> {
    private AccountStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountStub(channel, callOptions);
    }

    /**
     */
    public void generateKeygen(xyz.dapplink.iface.lib.GenerateKeygenRequest request,
        io.grpc.stub.StreamObserver<xyz.dapplink.iface.lib.GenerateKeygenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateKeygenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void generateSignature(xyz.dapplink.iface.lib.GenerateSignatureRequest request,
        io.grpc.stub.StreamObserver<xyz.dapplink.iface.lib.GenerateSignatureResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateSignatureMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Account.
   */
  public static final class AccountBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AccountBlockingStub> {
    private AccountBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountBlockingStub(channel, callOptions);
    }

    /**
     */
    public xyz.dapplink.iface.lib.GenerateKeygenResponse generateKeygen(xyz.dapplink.iface.lib.GenerateKeygenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateKeygenMethod(), getCallOptions(), request);
    }

    /**
     */
    public xyz.dapplink.iface.lib.GenerateSignatureResponse generateSignature(xyz.dapplink.iface.lib.GenerateSignatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateSignatureMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Account.
   */
  public static final class AccountFutureStub
      extends io.grpc.stub.AbstractFutureStub<AccountFutureStub> {
    private AccountFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<xyz.dapplink.iface.lib.GenerateKeygenResponse> generateKeygen(
        xyz.dapplink.iface.lib.GenerateKeygenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateKeygenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<xyz.dapplink.iface.lib.GenerateSignatureResponse> generateSignature(
        xyz.dapplink.iface.lib.GenerateSignatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateSignatureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_KEYGEN = 0;
  private static final int METHODID_GENERATE_SIGNATURE = 1;

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
        case METHODID_GENERATE_KEYGEN:
          serviceImpl.generateKeygen((xyz.dapplink.iface.lib.GenerateKeygenRequest) request,
              (io.grpc.stub.StreamObserver<xyz.dapplink.iface.lib.GenerateKeygenResponse>) responseObserver);
          break;
        case METHODID_GENERATE_SIGNATURE:
          serviceImpl.generateSignature((xyz.dapplink.iface.lib.GenerateSignatureRequest) request,
              (io.grpc.stub.StreamObserver<xyz.dapplink.iface.lib.GenerateSignatureResponse>) responseObserver);
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
          getGenerateKeygenMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              xyz.dapplink.iface.lib.GenerateKeygenRequest,
              xyz.dapplink.iface.lib.GenerateKeygenResponse>(
                service, METHODID_GENERATE_KEYGEN)))
        .addMethod(
          getGenerateSignatureMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              xyz.dapplink.iface.lib.GenerateSignatureRequest,
              xyz.dapplink.iface.lib.GenerateSignatureResponse>(
                service, METHODID_GENERATE_SIGNATURE)))
        .build();
  }

  private static abstract class AccountBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccountBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return xyz.dapplink.iface.lib.AccountProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Account");
    }
  }

  private static final class AccountFileDescriptorSupplier
      extends AccountBaseDescriptorSupplier {
    AccountFileDescriptorSupplier() {}
  }

  private static final class AccountMethodDescriptorSupplier
      extends AccountBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AccountMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AccountGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AccountFileDescriptorSupplier())
              .addMethod(getGenerateKeygenMethod())
              .addMethod(getGenerateSignatureMethod())
              .build();
        }
      }
    }
    return result;
  }
}
