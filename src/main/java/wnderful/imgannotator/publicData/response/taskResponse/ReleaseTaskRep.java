package wnderful.imgannotator.publicData.response.taskResponse;

import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.ReleaseTaskRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.taskVo.ReleaseTaskVo;

public class ReleaseTaskRep extends Response {
    private int code;
    private String message;
    private ReleaseTaskVo data;

    public ReleaseTaskRep(ReleaseTaskRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public ReleaseTaskRep(ReleaseTaskRepCode repCode,ReleaseTaskVo data) {
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

    public ReleaseTaskVo getData() {
        return data;
    }
}
