package xyz.dapplink.server.grpc;


import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import xyz.dapplink.iface.lib.*;
import xyz.dapplink.server.enums.SignType;
import xyz.dapplink.server.service.ISignService;

import java.util.List;


@GrpcService
@AllArgsConstructor
public class GrpcAccountService extends WalletServiceGrpc.WalletServiceImplBase {

    private final ISignService accountService;

    @Override
    public void getSupportSignWay(SupportSignWayRequest request, StreamObserver<SupportSignWayResponse> responseObserver) {
        int code = 0;
        String msg = "not support sign way";
        boolean supported = false;
        if (request.getType().trim().equalsIgnoreCase("ecdsa") || request.getType().trim().equalsIgnoreCase("eddsa")) {
            code = 1;
            msg = "support sign way";
            supported = true;
        }
        SupportSignWayResponse response = SupportSignWayResponse.newBuilder()
                .setMsg(msg)
                .setCode(String.valueOf(code))
                .setSupport(supported)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void exportPublicKeyList(ExportPublicKeyRequest request, StreamObserver<ExportPublicKeyResponse> responseObserver) {
        int code = 0;
        String msg = "error msg";
        List<PublicKey> resultList = accountService.generateKeyGen(Math.toIntExact(request.getNumber()), SignType.of(request.getType().toUpperCase()));
        ExportPublicKeyResponse response = ExportPublicKeyResponse.newBuilder()
                .setMsg(msg)
                .setCode(String.valueOf(code))
                .addAllPublicKey(resultList)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void signTxMessage(SignTxMessageRequest request, StreamObserver<SignTxMessageResponse> responseObserver) {
    }


}

