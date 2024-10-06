package xyz.dapplink.server.algorithm;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import org.springframework.stereotype.Component;
import xyz.dapplink.server.algorithm.dto.PairEntity;
import xyz.dapplink.server.enums.SignType;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
import java.security.spec.ECGenParameterSpec;
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
        KeyPairGenerator ecKPGen = KeyPairGenerator.getInstance("EC", "BC");
        ecKPGen.initialize(namedParamSpec);
        KeyPair ecKP = ecKPGen.generateKeyPair();
        return new PairEntity()
                .setPublicKey(Base64.getEncoder().encodeToString(ecKP.getPublic().getEncoded()))
                .setPrivateKey(Base64.getEncoder().encodeToString(ecKP.getPrivate().getEncoded()));
    }

    @Override
    public String sign(String publicKey, String msg) {
        return "";
    }
}
