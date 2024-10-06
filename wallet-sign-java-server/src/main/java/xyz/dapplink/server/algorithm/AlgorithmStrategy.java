package xyz.dapplink.server.algorithm;

import xyz.dapplink.server.algorithm.dto.PairEntity;


public interface AlgorithmStrategy {

    String getTypeName();

    PairEntity generateKeygen() throws Exception;

    String sign(String privateKey, String msg) throws Exception;

}
