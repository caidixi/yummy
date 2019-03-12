package wnderful.yummy.vo.memberVo;

public class MakeOrderVo {
    private String oid;
    private double totalPrice;
    private double packagePrice;
    private double deliveryPrice;

    public MakeOrderVo(String oid, double totalPrice, double packagePrice, double deliveryPrice) {
        this.oid = oid;
        this.totalPrice = totalPrice;
        this.packagePrice = packagePrice;
        this.deliveryPrice = deliveryPrice;
    }

    public MakeOrderVo() {
    }

    public String getOid() {
        return oid;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }
}
