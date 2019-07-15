package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.memberResponseCode.SearchFoodCode;
import wnderful.yummy.vo.memberVo.SearchFoodVo;

public class SearchFoodRes extends CommonResponse {

    public SearchFoodRes(SearchFoodCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public SearchFoodRes(SearchFoodCode code, SearchFoodVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
