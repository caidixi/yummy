package wnderful.yummy.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.yummy.dao.module.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
    BankAccount findByAccountId(String accountId);
}
