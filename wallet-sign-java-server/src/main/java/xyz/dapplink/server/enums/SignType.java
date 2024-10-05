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

}
