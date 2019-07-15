package wnderful.yummy.entity.entityInModule;

public enum RestaurantTypeName {
    FASTFOOD("快餐速食"),
    SNACK("精选小吃"),
    MAIN("正餐优选"),
    SUPERMARKET("超市"),
    FRUIT("鲜果购"),
    TEA("下午茶");

    private String stateName;

    RestaurantTypeName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
}
