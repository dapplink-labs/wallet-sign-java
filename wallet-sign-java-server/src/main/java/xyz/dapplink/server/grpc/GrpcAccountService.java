package xyz.dapplink.server.grpc;


import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import xyz.dapplink.iface.lib.*;
import xyz.dapplink.server.enums.SignType;
import xyz.dapplink.server.service.IAccountService;

import java.util.List;


@GrpcService
@AllArgsConstructor
public class GrpcAccountService extends AccountGrpc.AccountImplBase {

    private final IAccountService accountService;

    @Override
    public void generateKeygen(GenerateKeygenRequest request, StreamObserver<GenerateKeygenResponse> responseObserver) {
        Assert.isTrue(request.getNumber() > 0, "invalid number");
        List<String> publicKeyList = accountService.generateKeyGen(request.getNumber(), SignType.of(request.getMethod().name()));
        GenerateKeygenResponse response = GenerateKeygenResponse.newBuilder().addAllPublicKeyList(publicKeyList).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void generateSignature(GenerateSignatureRequest request, StreamObserver<GenerateSignatureResponse> responseObserver) {
        Assert.isTrue(StringUtils.hasLength(request.getPublicKey()), "invalid public key");
        Assert.isTrue(StringUtils.hasLength(request.getMsg()), "invalid transaction message");
        String signature = accountService.sign(request.getPublicKey(), request.getMsg());
        GenerateSignatureResponse response = GenerateSignatureResponse.newBuilder().setSignature(signature.trim()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

