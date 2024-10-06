package xyz.dapplink.server.algorithm;



import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.util.BigIntegers;
import org.springframework.stereotype.Component;
import xyz.dapplink.server.algorithm.dto.PairEntity;
import xyz.dapplink.server.enums.SignType;


import java.security.*;
import java.util.Base64;

@Component
public class BLSStrategy implements AlgorithmStrategy {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private final String type = SignType.BLS.getName();

    @Override
    public String getTypeName() {
        return type;
    }

    @Override
    public PairEntity generateKeygen() throws Exception {
        ECParameterSpec spec = ECNamedCurveTable.getParameterSpec("sect283k1");
        ECDomainParameters domainParams = new ECDomainParameters(spec.getCurve(), spec.getG(), spec.getN(), spec.getH());
        ECKeyPairGenerator keyGen = new ECKeyPairGenerator();
        ECKeyGenerationParameters keyGenParams = new ECKeyGenerationParameters(domainParams, CryptoServicesRegistrar.getSecureRandom());
        keyGen.init(keyGenParams);
        AsymmetricCipherKeyPair keyPair = keyGen.generateKeyPair();
        ECPublicKeyParameters publicKey = (ECPublicKeyParameters) keyPair.getPublic();
        ECPrivateKeyParameters privateKey = (ECPrivateKeyParameters) keyPair.getPrivate();
        return new PairEntity()
                .setPublicKey(Base64.getEncoder().encodeToString(publicKey.getQ().getEncoded(false)))
                .setPrivateKey(Base64.getEncoder().encodeToString( BigIntegers.asUnsignedByteArray(privateKey.getD())));
    }

    @Override
    public String sign(String publicKey, String msg) {
        return "";
    }
}
