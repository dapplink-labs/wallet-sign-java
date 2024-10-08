package xyz.dapplink.server.algorithm;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Component;
import xyz.dapplink.server.algorithm.dto.PairEntity;
import xyz.dapplink.server.enums.SignType;

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;



@Component
public class SchnorStrategy implements AlgorithmStrategy {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private final String type = SignType.SCHNOR.getName();

    @Override
    public String getTypeName() {
        return type;
    }

    @Override
    public PairEntity generateKeygen() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC", new BouncyCastleProvider());
        ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256k1"); // 使用 secp256k1 曲线
        keyPairGenerator.initialize(ecSpec, new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return new PairEntity()
                .setPublicKey(Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()))
                .setPrivateKey(Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded()));
    }

    @Override
    public String sign(String privateKey, String msg) throws Exception {
//
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
        KeyFactory keyFactory = KeyFactory.getInstance("EC", "BC");
        PrivateKey pk = keyFactory.generatePrivate(keySpec);


        return "";
    }
}
