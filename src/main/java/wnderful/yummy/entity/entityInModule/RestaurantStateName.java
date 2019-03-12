package wnderful.yummy.entity.entityInModule;

public enum RestaurantStateName {
    EXAMINE("examine"),
    FAIL("fail"),
    NORMAL("normal");

    private String stateName;

    RestaurantStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
}
