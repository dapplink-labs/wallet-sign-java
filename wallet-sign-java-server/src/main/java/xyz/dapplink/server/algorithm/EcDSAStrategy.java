package xyz.dapplink.server.algorithm;

import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.springframework.stereotype.Component;
import xyz.dapplink.server.algorithm.dto.PairEntity;
import xyz.dapplink.server.enums.SignType;

import java.security.*;
import java.util.Base64;

@Component
public class EcDSAStrategy implements AlgorithmStrategy {

    private final String type = SignType.ECDSA.getName();


    @Override
    public String getTypeName() {
        return type;
    }

    @Override
    public PairEntity generateKeygen() throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC", "BC");
        ECNamedCurveParameterSpec secp256k1 = ECNamedCurveTable.getParameterSpec("secp256k1");
        keyGen.initialize(secp256k1);
        KeyPair keyPair = keyGen.generateKeyPair();
        return new PairEntity()
                .setPublicKey(Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()))
                .setPrivateKey(Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded()));
    }

    @Override
    public String sign(String publicKey, String msg) {
        return "";
    }
}
