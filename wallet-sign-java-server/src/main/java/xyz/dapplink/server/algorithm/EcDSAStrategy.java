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
public class EcDSAStrategy implements AlgorithmStrategy {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private final String type = SignType.ECDSA.getName();


    @Override
    public String getTypeName() {
        return type;
    }

    @Override
    public PairEntity generateKeygen() throws Exception {
        ECGenParameterSpec namedParamSpec = new ECGenParameterSpec("secp256k1");
        KeyPairGenerator ecKPGen = KeyPairGenerator.getInstance("EC", new BouncyCastleProvider());
        ecKPGen.initialize(namedParamSpec);
        KeyPair ecKP = ecKPGen.generateKeyPair();
        return new PairEntity()
                .setPublicKey(Base64.getEncoder().encodeToString(ecKP.getPublic().getEncoded()))
                .setPrivateKey(Base64.getEncoder().encodeToString(ecKP.getPrivate().getEncoded()));
    }

    @Override
    public String sign(String privateKey, String msg) throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
        KeyFactory keyFactory = KeyFactory.getInstance("EC", new BouncyCastleProvider());
        PrivateKey pk = keyFactory.generatePrivate(keySpec);
        Signature signature = Signature.getInstance("SHA256withECDSA");
        signature.initSign(pk);
        signature.update(msg.getBytes());
        return Base64.getEncoder().encodeToString(signature.sign());
    }
}
