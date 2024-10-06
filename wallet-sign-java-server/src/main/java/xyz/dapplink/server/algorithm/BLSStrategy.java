package xyz.dapplink.server.algorithm;



import org.springframework.stereotype.Component;
import xyz.dapplink.server.algorithm.dto.PairEntity;
import xyz.dapplink.server.enums.SignType;


import java.security.*;

@Component
public class BLSStrategy implements AlgorithmStrategy {

    private final String type = SignType.BLS.getName();

    @Override
    public String getTypeName() {
        return type;
    }

    @Override
    public PairEntity generateKeygen() throws Exception {
        return null;
    }

    @Override
    public String sign(String publicKey, String msg) {
        return "";
    }
}
