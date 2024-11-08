package xyz.dapplink.server.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import xyz.dapplink.iface.lib.PublicKey;
import xyz.dapplink.server.algorithm.AlgorithmStrategy;
import xyz.dapplink.server.algorithm.dto.KeyPairDto;
import xyz.dapplink.server.enums.SignType;
import xyz.dapplink.server.service.AlgorithmService;
import xyz.dapplink.server.service.ISignService;
import xyz.dapplink.server.service.LevelDBService;
import xyz.dapplink.server.utils.HexStringUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignServiceImpl implements ISignService {

    private final AlgorithmService algorithmService;

    private final LevelDBService dbService;

    private ExecutorService executor;

    @PostConstruct
    public void init() {
        executor = Executors.newVirtualThreadPerTaskExecutor();
    }

    @Override
    public List<PublicKey> generateKeyGen(int number, SignType signType) {
        Assert.isTrue(number > 0 && number <= 100000, "invalid numbers");
        List<PublicKey> keyList = new ArrayList<>(number);
        List<Future<KeyPairDto>> futures = new ArrayList<>(number);
        Map<byte[], byte[]> dataMap = new HashMap<>(number);
        AlgorithmStrategy strategyService = algorithmService.getStrategy(signType);
        log.info("start method:{}", LocalDateTime.now());
        for (int i = 0; i < number; i++) {
            Future<KeyPairDto> future = executor.submit(() -> {
                KeyPairDto keyPairDto;
                try {
                    keyPairDto = strategyService.generateKeygen();
                } catch (RuntimeException e) {
                    log.error("generateKeyGen error:{}", e.getMessage(), e);
                    throw new RuntimeException(e.getMessage());
                }
                return keyPairDto;
            });
            futures.add(future);
        }
        log.info("after for i:{}", LocalDateTime.now());
        futures.forEach(f -> {
            try {
                KeyPairDto keyPairDto = f.get();
                dataMap.put(keyPairDto.getPublicKey(), keyPairDto.getPrivateKey().toByteArray());
                keyList.add(PublicKey.newBuilder().setCompressPubkey(HexStringUtils.byteArrayToHexString(keyPairDto.getCompressPublicKey())).setDecompressPubkey(HexStringUtils.byteArrayToHexString(keyPairDto.getPublicKey())).build());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        log.info("after foreach:{}", LocalDateTime.now());
        dbService.batchSave(dataMap);
        log.info("after batchSave:{}", LocalDateTime.now());
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
