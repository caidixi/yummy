package wnderful.yummy.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.dao.module.BankAccount;
import wnderful.yummy.dao.repository.BankAccountRepository;
import wnderful.yummy.dataService.AccountDataService;

@Service
public class AccountDataServiceImpl implements AccountDataService {
    private BankAccountRepository bankAccountRepository;

    @Autowired
    public AccountDataServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public boolean accountExist(String accountId) {
        return bankAccountRepository.findByAccountId(accountId)!=null;
    }

    @Override
    public boolean checkBalance(String accountId, double consume) {
        BankAccount account = bankAccountRepository.findByAccountId(accountId);
        return account.getBalance()>=consume;
    }

    @Override
    public boolean checkPassword(String accountId, String accountPassword) {
        BankAccount account = bankAccountRepository.findByAccountId(accountId);
        return accountPassword.equals(account.getPassword());
    }

    @Override
    public void consume(String accountId,String restaurantAccountId, double consume) {
        BankAccount memberAccount = bankAccountRepository.findByAccountId(accountId);
        BankAccount restaurantAccount = bankAccountRepository.findByAccountId(restaurantAccountId);
        memberAccount.setBalance(memberAccount.getBalance()-consume);
        restaurantAccount.setBalance(restaurantAccount.getBalance()+consume);
        bankAccountRepository.save(memberAccount);
        bankAccountRepository.save(restaurantAccount);
    }
}
