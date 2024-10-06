package xyz.dapplink.server.algorithm;

import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.Ed25519KeyPairGenerator;
import org.bouncycastle.crypto.params.Ed25519KeyGenerationParameters;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Component;
import xyz.dapplink.server.algorithm.dto.PairEntity;
import xyz.dapplink.server.enums.SignType;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@Component
public class EdDSAStrategy implements AlgorithmStrategy {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private final String type = SignType.EDDSA.getName();

    @Override
    public String getTypeName() {
        return type;
    }

    @Override
    public PairEntity generateKeygen() throws Exception {
        Ed25519KeyPairGenerator keyGen = new Ed25519KeyPairGenerator();
        keyGen.init(new Ed25519KeyGenerationParameters(new SecureRandom()));
        AsymmetricCipherKeyPair keyPair = keyGen.generateKeyPair();
        Ed25519PrivateKeyParameters privateKey = (Ed25519PrivateKeyParameters) keyPair.getPrivate();
        Ed25519PublicKeyParameters publicKey = (Ed25519PublicKeyParameters) keyPair.getPublic();
        return new PairEntity()
                .setPublicKey(Base64.getEncoder().encodeToString(publicKey.getEncoded()))
                .setPrivateKey(Base64.getEncoder().encodeToString(privateKey.getEncoded()));
    }

    @Override
    public String sign(String privateKey, String msg) throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
        KeyFactory keyFactory = KeyFactory.getInstance("Ed25519");
        PrivateKey pk = keyFactory.generatePrivate(keySpec);
        Signature signature = Signature.getInstance("Ed25519", "BC");
        signature.initSign(pk);
        signature.update(msg.getBytes());
        return Base64.getEncoder().encodeToString(signature.sign());
    }
}
