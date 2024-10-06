package xyz.dapplink.server.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import xyz.dapplink.server.algorithm.dto.PairEntity;
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
            PairEntity pair;
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
        List<Account> accounts = accountRepository.findAccountByPublicKey(publicKey);
        Assert.isTrue(accounts.size() == 1, "无效公钥");
        return algorithmService.getStrategy(SignType.valueOf(accounts.getFirst().getCryptoMethod())).sign(publicKey, msg);
    }
}
