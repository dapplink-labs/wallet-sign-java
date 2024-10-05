package xyz.dapplink.server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Account extends BaseEntity {

    @Lob
    private String publicKey;

    @Lob
    private String privateKey;

    private String address;

    private String cryptoMethod;

}


