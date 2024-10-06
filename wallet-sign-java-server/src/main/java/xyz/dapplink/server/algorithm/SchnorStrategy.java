package xyz.dapplink.server.algorithm;

import org.springframework.stereotype.Component;
import xyz.dapplink.server.algorithm.dto.PairEntity;
import xyz.dapplink.server.enums.SignType;



@Component
public class SchnorStrategy implements AlgorithmStrategy {

    private final String type = SignType.SCHNOR.getName();

    @Override
    public String getTypeName() {
        return type;
    }

    @Override
    public PairEntity generateKeygen() throws Exception {
        return null;
    }

    @Override
    public String sign(String privateKey, String msg) {
        return "";
    }
}
