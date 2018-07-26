package wnderful.imgannotator.publicData.response.userResponse;

import wnderful.imgannotator.publicData.reponseCode.userResponseCode.GetUserMassageRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.userVo.UserMassageVo;

public class GetUserMassageRep extends Response {
    private int code;
    private String message;
    private UserMassageVo data;

    public GetUserMassageRep(GetUserMassageRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public GetUserMassageRep(GetUserMassageRepCode repCode,UserMassageVo data) {
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

    public UserMassageVo getData() {
        return data;
    }
}
