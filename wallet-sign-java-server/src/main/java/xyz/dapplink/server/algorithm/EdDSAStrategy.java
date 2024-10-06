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

import java.security.SecureRandom;
import java.security.Security;
import java.util.Base64;

@Component
public class EdDSAStrategy implements AlgorithmStrategy {

    private final String type = SignType.EDDSA.getName();

    @Override
    public String getTypeName() {
        return type;
    }

    @Override
    public PairEntity generateKeygen() throws Exception {
        Security.addProvider(new BouncyCastleProvider());
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
    public String sign(String publicKey, String msg) {
        return "";
    }
}
