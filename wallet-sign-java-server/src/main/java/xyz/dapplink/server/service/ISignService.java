package xyz.dapplink.server.service;

import xyz.dapplink.iface.lib.PublicKey;
import xyz.dapplink.server.enums.SignType;

import java.util.List;

public interface ISignService {

    List<PublicKey> generateKeyGen(int number, SignType signType);

    String sign(String publicKey, String msg);

}
