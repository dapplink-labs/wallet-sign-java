package xyz.dapplink.server.algorithm;

import org.springframework.stereotype.Component;
import xyz.dapplink.server.algorithm.dto.PairEntity;
import xyz.dapplink.server.enums.SignType;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

@Component
public class RSAStrategy implements AlgorithmStrategy {

    private final String type = SignType.RSA.getName();


    @Override
    public String getTypeName() {
        return type;
    }

    @Override
    public PairEntity generateKeygen() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        return new PairEntity()
                .setPublicKey(Base64.getEncoder().encodeToString(rsaPublicKey.getEncoded()))
                .setPrivateKey(Base64.getEncoder().encodeToString(rsaPrivateKey.getEncoded()));

    }

    @Override
    public String sign(String publicKey, String msg) {
        return "";
    }
}
