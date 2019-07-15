package wnderful.yummy.entity.entityInModule;

public enum OrderStateName {
    UNPAID("unpaid"),
    CANCEL("cancel"),
    PAID("paid"),
    DONE("done"),
    ASSESSED("assessed");

    private String stateName;

    OrderStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
}
