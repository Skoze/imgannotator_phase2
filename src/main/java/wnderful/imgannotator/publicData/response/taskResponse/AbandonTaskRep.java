package wnderful.imgannotator.publicData.response.taskResponse;

import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.*;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.taskVo.*;

public class AbandonTaskRep extends Response {
    private int code;
    private String message;
    private AbandonTaskVo data;

    public AbandonTaskRep(AbandonTaskRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }


    public AbandonTaskRep(AbandonTaskRepCode repCode,AbandonTaskVo data) {
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

    public AbandonTaskVo getData() {
        return data;
    }
}
