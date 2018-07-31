package wnderful.imgannotator.publicData.response.MarkResponse;

import wnderful.imgannotator.publicData.reponseCode.markResponseCode.GetMarkRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.MarkVo.AMarkVo;

public class GetMarkRep extends Response {
    private int code;
    private String message;
    private AMarkVo data;

    public GetMarkRep(GetMarkRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public GetMarkRep(GetMarkRepCode repCode,AMarkVo data) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
        this.data = data;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public AMarkVo getData() {
        return data;
    }
}
