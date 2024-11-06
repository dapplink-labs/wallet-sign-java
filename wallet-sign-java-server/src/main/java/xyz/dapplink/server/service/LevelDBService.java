package xyz.dapplink.server.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.iq80.leveldb.*;
import org.iq80.leveldb.impl.Iq80DBFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Component
public class LevelDBService {

    @Value("${levelDB.db-path}")
    private String DBPath;

    private DB db;

    @PostConstruct
    public void init() {
        DBFactory factory = new Iq80DBFactory();
        File file = new File(DBPath);
        Options options = new Options();
        options.createIfMissing(true);
        try {
            db = factory.open(file, options);
        } catch (IOException e) {
            log.error("LevelDBService error:{}", e.getMessage(), e);
        }
    }

    public void save(byte[] key, byte[] value) {
        WriteOptions writeOptions = new WriteOptions().sync(true);
        db.put(key, value, writeOptions);
    }

    public void batchSave(Map<byte[], byte[]> data) {
        WriteBatch writeBatch = db.createWriteBatch();
        data.forEach(writeBatch::put);
        db.write(writeBatch);
    }

    public byte[] getByPublicKey(byte[] publicKey) {
        return db.get(publicKey);
    }

}

