package wnderful.imgannotator.publicData.response.userResponse;

import wnderful.imgannotator.publicData.reponseCode.userResponseCode.GetUserMassageRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.userVo.UserMessageVo;

public class GetUserMassageRep extends Response {
    private int code;
    private String message;
    private UserMessageVo data;

    public GetUserMassageRep(GetUserMassageRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public GetUserMassageRep(GetUserMassageRepCode repCode,UserMessageVo data) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public UserMessageVo getData() {
        return data;
    }
}
