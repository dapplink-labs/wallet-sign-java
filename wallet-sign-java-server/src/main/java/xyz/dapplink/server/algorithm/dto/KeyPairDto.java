package xyz.dapplink.server.algorithm.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class KeyPairDto implements Serializable {

    private String publicKey;

    private String privateKey;

    private String compressPublicKey;

}
