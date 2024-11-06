package xyz.dapplink.server.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import xyz.dapplink.iface.lib.PublicKey;
import xyz.dapplink.server.algorithm.dto.KeyPairDto;
import xyz.dapplink.server.enums.SignType;
import xyz.dapplink.server.service.AlgorithmService;
import xyz.dapplink.server.service.IAccountService;
import xyz.dapplink.server.service.LevelDBService;

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
        List<PublicKey> keyList = new LinkedList<>();
        Map<byte[], byte[]> objList = new HashMap<>();
        for (int i = 0; i < number; i++) {
            KeyPairDto keyPairDto;
            try {
                keyPairDto = algorithmService.getStrategy(signType).generateKeygen();
                objList.put(keyPairDto.getPublicKey().getBytes(), keyPairDto.getPrivateKey().getBytes());
            } catch (Exception e) {
                log.error("generateKeyGen error:{}", e.getMessage(), e);
                throw new RuntimeException(e.getMessage());
            }
            PublicKey key = PublicKey.newBuilder().setCompressPubkey(keyPairDto.getCompressPublicKey()).setDecompressPubkey(keyPairDto.getPublicKey()).build();
            keyList.add(key);
        }
        dbService.batchSave(objList);
        return keyList;
    }

    @Override
    public String sign(String publicKey, String msg) {

        return null;
    }
}
