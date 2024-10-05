package xyz.dapplink.server.grpc;


import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import xyz.dapplink.iface.lib.HelloReply;
import xyz.dapplink.iface.lib.HelloRequest;
import xyz.dapplink.iface.lib.SimpleGrpc;

@GrpcService
@AllArgsConstructor
public class GrpcAccountService extends SimpleGrpc.SimpleImplBase {

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}
