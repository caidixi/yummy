package wnderful.yummy.entity.entityInModule;

public enum RestaurantTypeName {
    FASTFOOD("简餐便当"),
    SNACK("小吃"),
    WESTERN("西餐"),
    REGIONAL("地方菜系"),
    NOODLE("面食粥点");
    private String stateName;

    RestaurantTypeName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
}
