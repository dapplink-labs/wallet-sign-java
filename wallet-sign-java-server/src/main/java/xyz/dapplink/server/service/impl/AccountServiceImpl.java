package xyz.dapplink.server.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import xyz.dapplink.server.algorithm.dto.KeyPairDto;
import xyz.dapplink.server.entity.Account;
import xyz.dapplink.server.enums.SignType;
import xyz.dapplink.server.repository.AccountRepository;
import xyz.dapplink.server.service.AlgorithmService;
import xyz.dapplink.server.service.IAccountService;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final AccountRepository accountRepository;

    private final AlgorithmService algorithmService;

    @Override
    public List<String> generateKeyGen(int number, SignType signType) {
        List<String> result = new LinkedList<>();
        List<Account> accountList = new LinkedList<>();
        for (int i = 0; i < number; i++) {
            KeyPairDto pair;
            try {
                pair = algorithmService.getStrategy(signType).generateKeygen();
                accountList.add(new Account().setPublicKey(pair.getPublicKey()).setPrivateKey(pair.getPrivateKey()).setCryptoMethod(signType.getName()));
                result.add(pair.getPublicKey());
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        accountRepository.saveAll(accountList);
        return result;
    }

    @Override
    public String sign(String publicKey, String msg) {
        Assert.isTrue(StringUtils.hasLength(publicKey.trim()),"无效公钥");
        Assert.isTrue(StringUtils.hasLength(msg.trim()) && msg.trim().length() == 32, "无效Msg");
        List<Account> accounts = accountRepository.findAccountByPublicKey(publicKey.trim());
        Assert.isTrue(accounts.size() == 1, "无效公钥");
        Account account = accounts.getFirst();
        String signature = "";
        try {
            signature = algorithmService.getStrategy(SignType.valueOf(account.getCryptoMethod())).sign(account.getPrivateKey(), msg.trim());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return signature;
    }
}
