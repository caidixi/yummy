package wnderful.yummy.dataService;

public interface AccountDataService {
    boolean accountExist(String accountId);

    boolean checkBalance(String accountId,double consume);

    boolean checkPassword(String accountId,String accountPassword);

    void consume(String accountId,String restaurantAccountId,double consume);
}
