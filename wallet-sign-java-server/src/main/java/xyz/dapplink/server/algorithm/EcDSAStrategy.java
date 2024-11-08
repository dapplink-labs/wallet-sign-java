package xyz.dapplink.server.algorithm;

import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import org.bouncycastle.math.ec.ECPoint;
import org.springframework.stereotype.Component;
import xyz.dapplink.server.algorithm.dto.KeyPairDto;
import xyz.dapplink.server.enums.SignType;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@Component
public class EcDSAStrategy implements AlgorithmStrategy {


    static {
        Security.addProvider(new BouncyCastleProvider());
        // choose curve parameters, secp256k1
        X9ECParameters ecParams = SECNamedCurves.getByOID(SECObjectIdentifiers.secp256k1);
        domainParams = new ECDomainParameters(ecParams.getCurve(), ecParams.getG(), ecParams.getN(), ecParams.getH());
    }

    private final String type = SignType.ECDSA.getName();

    private static final ECDomainParameters domainParams;

    @Override
    public String getTypeName() {
        return type;
    }

    @Override
    public KeyPairDto generateKeygen() throws Exception {


        // create generator and init
        ECKeyPairGenerator generator = new ECKeyPairGenerator();
        ECKeyGenerationParameters genParams = new ECKeyGenerationParameters(domainParams, new SecureRandom());
        generator.init(genParams);

        // generate keypair
        AsymmetricCipherKeyPair keyPair = generator.generateKeyPair();
        ECPrivateKeyParameters privateParams = (ECPrivateKeyParameters) keyPair.getPrivate();
        ECPublicKeyParameters publicParams = (ECPublicKeyParameters) keyPair.getPublic();

        // get public key point
        ECPoint publicKeyPoint = publicParams.getQ();

        BigInteger privateKey = privateParams.getD();

        // get compress public key
        byte[] compressedPublicKey = publicKeyPoint.getEncoded(true);

        // get uncompressed public key
        byte[] uncompressedPublicKey = publicKeyPoint.getEncoded(false);

        return new KeyPairDto()
                .setPrivateKey(privateKey)
                .setPublicKey(uncompressedPublicKey)
                .setCompressPublicKey(compressedPublicKey);
    }

    @Override
    public String sign(String privateKey, String msg) throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        PrivateKey pk = keyFactory.generatePrivate(keySpec);
        Signature signature = Signature.getInstance("SHA256withECDSA");
        signature.initSign(pk);
        signature.update(msg.getBytes());
        return Base64.getEncoder().encodeToString(signature.sign());
    }
}
