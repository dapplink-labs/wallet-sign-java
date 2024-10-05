package xyz.dapplink.server.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@Table(indexes = {@Index(columnList = "publicKey", unique = true)})
public class Account extends BaseEntity {

    @Lob
    private String publicKey;

    @Lob
    private String privateKey;

    @Lob
    private String address;

    private String cryptoMethod;

}


