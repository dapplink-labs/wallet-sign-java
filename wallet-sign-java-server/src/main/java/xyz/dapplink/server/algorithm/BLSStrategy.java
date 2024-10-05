package xyz.dapplink.server.algorithm;

import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.springframework.stereotype.Component;
import xyz.dapplink.server.algorithm.dto.PairEntity;
import xyz.dapplink.server.enums.SignType;

import java.security.*;
import java.util.Base64;

@Component
public class BLSStrategy implements AlgorithmStrategy{

    private final String type = SignType.BLS.getName();

    @Override
    public String getTypeName() {
        return type;
    }

    @Override
    public PairEntity generateKeygen() throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC", "BC");
        String curveName = "BLS12-381";
        ECNamedCurveParameterSpec spec = ECNamedCurveTable.getParameterSpec(curveName);
        ECNamedCurveSpec ecSpec = new ECNamedCurveSpec(curveName, spec.getCurve(), spec.getG(), spec.getN());

        // 初始化KeyPairGenerator
        keyGen.initialize(ecSpec);

        // 生成密钥对
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
