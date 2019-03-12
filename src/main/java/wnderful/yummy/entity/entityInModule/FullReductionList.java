package wnderful.yummy.entity.entityInModule;

import wnderful.yummy.entity.FullReduction;

public class FullReductionList {
    private FullReduction[] fullReductions;


    public FullReductionList() {
    }

    public FullReductionList(FullReduction[] fullReductions) {
        this.fullReductions = fullReductions;
    }

    public FullReduction[] getFullReductions() {
        return fullReductions;
    }

    public void setFullReductions(FullReduction[] fullReductions) {
        this.fullReductions = fullReductions;
    }
}
