package wnderful.imgannotator.publicData.response.taskResponse;

import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.DeleteTaskRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.taskVo.DeleteTaskVo;

public class DeleteTaskRep extends Response {
    private int code;
    private String message;
    private DeleteTaskVo data;

    public DeleteTaskRep(DeleteTaskRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public DeleteTaskRep(DeleteTaskRepCode repCode,DeleteTaskVo data) {
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

    public DeleteTaskVo getData() {
        return data;
    }
}
