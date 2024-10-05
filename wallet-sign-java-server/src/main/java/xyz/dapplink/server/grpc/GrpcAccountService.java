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
        Assert.isTrue(request.getNumber() > 0, "无效集合大小");
        List<String> publicKeyList = accountService.generateKeyGen(request.getNumber(), SignType.valueOf(request.getMethod().name()));
        GenerateKeygenResponse.Builder builder = GenerateKeygenResponse.newBuilder();
        for (int i = 0; i < publicKeyList.size(); i++) {
            builder.setPublicKeyList(i, publicKeyList.get(i));
        }
        GenerateKeygenResponse response = builder.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void generateSignature(GenerateSignatureRequest request, StreamObserver<GenerateSignatureResponse> responseObserver) {
        Assert.isTrue(StringUtils.hasLength(request.getPublicKey()), "无效公钥");
        Assert.isTrue(StringUtils.hasLength(request.getMsg()), "无效MSG");
        String signature = accountService.sign(request.getPublicKey(), request.getMsg());
        GenerateSignatureResponse response = GenerateSignatureResponse.newBuilder().setSignature(signature).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

