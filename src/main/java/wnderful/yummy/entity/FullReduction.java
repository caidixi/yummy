package wnderful.yummy.entity;

public class FullReduction {
    private double amount;
    private double reduce;

    public FullReduction(double amount, double reduce) {
        this.amount = amount;
        this.reduce = reduce;
    }

    public FullReduction() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getReduce() {
        return reduce;
    }

    public void setReduce(double reduce) {
        this.reduce = reduce;
    }
}
