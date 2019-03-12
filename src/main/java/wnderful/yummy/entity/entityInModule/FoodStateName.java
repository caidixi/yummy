package wnderful.yummy.entity.entityInModule;

public enum FoodStateName {
    NORMAL("normal"),
    EMPTY("empty"),
    CANCEL("cancel");
    private String stateName;

    FoodStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
}
