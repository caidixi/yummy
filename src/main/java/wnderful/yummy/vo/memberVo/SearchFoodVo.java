package wnderful.yummy.vo.memberVo;

import wnderful.yummy.entity.voEntity.SearchFoodResult;

public class SearchFoodVo {
    private SearchFoodResult[] searchFoodResults;

    public SearchFoodVo(SearchFoodResult[] searchFoodResults) {
        this.searchFoodResults = searchFoodResults;
    }

    public SearchFoodResult[] getSearchFoodResults() {
        return searchFoodResults;
    }
}
