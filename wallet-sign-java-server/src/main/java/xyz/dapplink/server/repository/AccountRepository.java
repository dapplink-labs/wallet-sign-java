package xyz.dapplink.server.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.dapplink.server.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
