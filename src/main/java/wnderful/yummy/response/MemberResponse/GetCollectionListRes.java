package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.memberResponseCode.GetCollectionListResCode;
import wnderful.yummy.vo.memberVo.GetRestListVo;

public class GetCollectionListRes extends CommonResponse {
    public GetCollectionListRes(GetCollectionListResCode code) {
        setResult(code.getCode());
        setOpinion(code.getMessage());
    }

    public GetCollectionListRes(GetCollectionListResCode code, GetRestListVo vo) {
        setResult(code.getCode());
        setOpinion(code.getMessage());
        setBody(vo);
    }
}
