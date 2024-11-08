package xyz.dapplink.server.algorithm.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@Accessors(chain = true)
public class KeyPairDto implements Serializable {

    private BigInteger privateKey;

    private byte[] publicKey;

    private byte[] compressPublicKey;

}
