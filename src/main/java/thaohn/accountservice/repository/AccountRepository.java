package thaohn.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thaohn.accountservice.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
