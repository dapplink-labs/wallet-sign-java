package xyz.dapplink.server.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.dapplink.server.entity.Account;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

    List<Account> findAccountByPublicKey(String publicKey);

}
