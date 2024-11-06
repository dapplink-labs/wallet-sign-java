package xyz.dapplink.server.algorithm;

import xyz.dapplink.server.algorithm.dto.KeyPairDto;


public interface AlgorithmStrategy {

    String getTypeName();

    KeyPairDto generateKeygen() throws Exception ;

    String sign(String privateKey, String msg) throws Exception ;

}
