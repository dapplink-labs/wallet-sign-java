package xyz.dapplink.server.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SignType {

    ECDSA("ECDSA"),
    EDDSA("EDDSA"),
    BLS("BLS"),
    RSA("RSA"),
    SCHNOR("SCHNOR");

    private final String name;

    public static SignType of(String name) {
        for (SignType signType : SignType.values()) {
            if (signType.name.equals(name)) {
                return signType;
            }
        }
        throw new RuntimeException("无效类型");
    }

}
