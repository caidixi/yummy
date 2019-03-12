package wnderful.yummy.entity.entityInModule;

public enum MemberStateName {
    CANCEL("cancel"),
    NORMAL("normal");

    private String stateName;

    MemberStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
}
