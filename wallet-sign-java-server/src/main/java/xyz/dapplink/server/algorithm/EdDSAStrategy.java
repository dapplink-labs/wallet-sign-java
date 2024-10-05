package xyz.dapplink.server.algorithm;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Component;
import xyz.dapplink.server.algorithm.dto.PairEntity;
import xyz.dapplink.server.enums.SignType;

import java.security.*;
import java.util.Base64;

@Component
public class EdDSAStrategy implements AlgorithmStrategy {

    private final String type = SignType.EDDSA.getName();

    @Override
    public String getTypeName() {
        return type;
    }

    @Override
    public PairEntity generateKeygen() throws Exception{
        Security.addProvider(new BouncyCastleProvider());

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EdDSA", "BC");
        keyGen.initialize(0);
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
