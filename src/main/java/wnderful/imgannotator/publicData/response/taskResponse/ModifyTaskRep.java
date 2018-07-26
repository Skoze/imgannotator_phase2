package wnderful.imgannotator.publicData.response.taskResponse;

import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.ModifyTaskRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.taskVo.ModifyTaskVo;

public class ModifyTaskRep extends Response {
    private int code;
    private String message;
    private ModifyTaskVo data;

    public ModifyTaskRep(ModifyTaskRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public ModifyTaskRep(ModifyTaskRepCode repCode,ModifyTaskVo data) {
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

    public ModifyTaskVo getData() {
        return data;
    }
}
