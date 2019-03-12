package wnderful.yummy.vo.managerVo;

public class FinancialStatisticsVo {
    private int totalOrder;
    private double totalIncome;

    public FinancialStatisticsVo() {
    }

    public FinancialStatisticsVo(int totalOrder, double totalIncome) {
        this.totalOrder = totalOrder;
        this.totalIncome = totalIncome;
    }

    public int getTotalOrder() {
        return totalOrder;
    }

    public double getTotalIncome() {
        return totalIncome;
    }
}
