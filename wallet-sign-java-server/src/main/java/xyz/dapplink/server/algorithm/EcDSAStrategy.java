package xyz.dapplink.server.algorithm;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;

import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.springframework.stereotype.Component;
import xyz.dapplink.server.algorithm.dto.PairEntity;
import xyz.dapplink.server.enums.SignType;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
import java.security.spec.ECParameterSpec;
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
        ECNamedCurveParameterSpec secp256k1 = (ECNamedCurveParameterSpec) org.bouncycastle.jce.provider.BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
        ECParameterSpec ecSpec = new ECNamedCurveSpec("secp256k1", secp256k1.getCurve(), secp256k1.getG(), secp256k1.getN());

        keyGen.initialize(ecSpec);
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
