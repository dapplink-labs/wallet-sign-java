package xyz.dapplink.server.algorithm;

import xyz.dapplink.server.algorithm.dto.PairEntity;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;

public interface AlgorithmStrategy {

    String getTypeName();

    PairEntity generateKeygen() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException;

    String sign(String publicKey, String msg);

}
