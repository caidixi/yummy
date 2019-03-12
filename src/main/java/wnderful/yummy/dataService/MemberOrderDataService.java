package wnderful.yummy.dataService;

public interface MemberOrderDataService {
    void payOrder(String accountId, String oid);

    boolean orderCanPay(String oid,String accountId);
}
