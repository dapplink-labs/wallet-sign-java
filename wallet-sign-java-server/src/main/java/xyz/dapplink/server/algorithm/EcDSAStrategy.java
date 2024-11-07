package xyz.dapplink.server.algorithm;

import jakarta.annotation.PostConstruct;
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
import xyz.dapplink.server.utils.HexStringUtils;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@Component
public class EcDSAStrategy implements AlgorithmStrategy {
    

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private final String type = SignType.ECDSA.getName();

    @PostConstruct
    public void init() {


    }

    @Override
    public String getTypeName() {
        return type;
    }

    @Override
    public KeyPairDto generateKeygen() throws Exception {
        // 选择椭圆曲线参数，这里以 secp256k1 为例
        X9ECParameters ecParams = SECNamedCurves.getByOID(SECObjectIdentifiers.secp256k1);
        ECDomainParameters domainParams = new ECDomainParameters(ecParams.getCurve(), ecParams.getG(), ecParams.getN(), ecParams.getH());

        // 创建密钥对生成器并初始化
        ECKeyPairGenerator generator = new ECKeyPairGenerator();
        ECKeyGenerationParameters genParams = new ECKeyGenerationParameters(domainParams, new SecureRandom());
        generator.init(genParams);

        // 生成密钥对
        AsymmetricCipherKeyPair keyPair = generator.generateKeyPair();
        ECPrivateKeyParameters privParams = (ECPrivateKeyParameters) keyPair.getPrivate();
        ECPublicKeyParameters pubParams = (ECPublicKeyParameters) keyPair.getPublic();

        // 获取公钥点
        ECPoint publicKeyPoint = pubParams.getQ();

        BigInteger privateKey = privParams.getD();

        // 获取压缩公钥
        byte[] compressedPublicKey = publicKeyPoint.getEncoded(true);

        // 获取非压缩公钥
        byte[] uncompressedPublicKey = publicKeyPoint.getEncoded(false);

        return new KeyPairDto()
                .setPrivateKey(privateKey.toString(16))
                .setPublicKey(HexStringUtils.byteArrayToHexString(uncompressedPublicKey))
                .setCompressPublicKey(HexStringUtils.byteArrayToHexString(compressedPublicKey));
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
