package xyz.dapplink.server.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.dapplink.server.repository.AccountRepository;
import xyz.dapplink.server.service.IAccountService;

@Slf4j
@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final AccountRepository accountRepository;


}
