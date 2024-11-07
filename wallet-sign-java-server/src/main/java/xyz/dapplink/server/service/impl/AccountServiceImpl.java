package xyz.dapplink.server.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import xyz.dapplink.iface.lib.PublicKey;
import xyz.dapplink.server.algorithm.AlgorithmStrategy;
import xyz.dapplink.server.algorithm.dto.KeyPairDto;
import xyz.dapplink.server.enums.SignType;
import xyz.dapplink.server.service.AlgorithmService;
import xyz.dapplink.server.service.IAccountService;
import xyz.dapplink.server.service.LevelDBService;
import xyz.dapplink.server.utils.HexStringUtils;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final AlgorithmService algorithmService;

    private final LevelDBService dbService;

    @Override
    public List<PublicKey> generateKeyGen(int number, SignType signType) {
        Assert.isTrue(number > 0 && number <= 100000, "invalid numbers");
        List<PublicKey> keyList = new ArrayList<>(number);
        Map<byte[], byte[]> objList = new HashMap<>(number);
        AlgorithmStrategy strategyService = algorithmService.getStrategy(signType);
        log.info("start generate: {}", LocalDateTime.now());
        for (int i = 0; i < number; i++) {
            KeyPairDto keyPairDto;
            try {
                keyPairDto = strategyService.generateKeygen();
                objList.put(keyPairDto.getPublicKey().getBytes(), keyPairDto.getPrivateKey().getBytes());
            } catch (Exception e) {
                log.error("generateKeyGen error:{}", e.getMessage(), e);
                throw new RuntimeException(e.getMessage());
            }
            keyList.add(PublicKey.newBuilder().setCompressPubkey(keyPairDto.getCompressPublicKey()).setDecompressPubkey(keyPairDto.getPublicKey()).build());
        }
        dbService.batchSave(objList);
        return keyList;
    }

    @Override
    public String sign(String publicKey, String msg) {
        Assert.isTrue(msg.length() == 32, "invalid string length");
        byte[] bytesPublicKey = dbService.getByPublicKey(HexStringUtils.hexStringToByteArray(publicKey));
        Assert.notNull(bytesPublicKey, "empty result");
        return null;
    }
}
