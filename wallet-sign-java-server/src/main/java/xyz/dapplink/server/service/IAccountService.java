package xyz.dapplink.server.service;

import xyz.dapplink.server.enums.SignType;

import java.util.List;

public interface IAccountService {

    List<String> generateKeyGen(int number, SignType signType);

    String sign(String publicKey);

}
