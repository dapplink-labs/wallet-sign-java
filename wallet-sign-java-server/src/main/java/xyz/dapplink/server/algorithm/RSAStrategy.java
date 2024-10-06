package xyz.dapplink.server.algorithm;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Component;
import xyz.dapplink.server.algorithm.dto.PairEntity;
import xyz.dapplink.server.enums.SignType;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@Component
public class RSAStrategy implements AlgorithmStrategy {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

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
    public String sign(String privateKey, String msg) throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey pk = keyFactory.generatePrivate(keySpec);
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(pk);
        signature.update(msg.getBytes());
        return Base64.getEncoder().encodeToString(signature.sign());
    }
}
