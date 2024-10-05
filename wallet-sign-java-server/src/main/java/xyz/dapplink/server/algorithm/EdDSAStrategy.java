package xyz.dapplink.server.algorithm;

import org.springframework.stereotype.Component;
import xyz.dapplink.server.algorithm.dto.PairEntity;
import xyz.dapplink.server.enums.SignType;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.EdECPrivateKey;
import java.security.interfaces.EdECPublicKey;
import java.util.Base64;

@Component
public class EdDSAStrategy implements AlgorithmStrategy {

    private final String type = SignType.EDDSA.getName();

    @Override
    public String getTypeName() {
        return type;
    }

    @Override
    public PairEntity generateKeygen() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EdDSA");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        EdECPublicKey edPublicKey = (EdECPublicKey) keyPair.getPublic();
        EdECPrivateKey edPrivateKey = (EdECPrivateKey) keyPair.getPrivate();
        return new PairEntity()
                .setPublicKey(Base64.getEncoder().encodeToString(edPublicKey.getEncoded()))
                .setPrivateKey(Base64.getEncoder().encodeToString(edPrivateKey.getEncoded()));
    }
}
