package xyz.dapplink.server.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.dapplink.server.enums.SignType;
import xyz.dapplink.server.repository.AccountRepository;
import xyz.dapplink.server.service.IAccountService;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final AccountRepository accountRepository;


    @Override
    public List<String> generateKeyGen(int number, SignType signType) {
        List<String> result =  new LinkedList<>();
        return List.of();
    }

    @Override
    public String sign(String publicKey) {
        return "";
    }
}
