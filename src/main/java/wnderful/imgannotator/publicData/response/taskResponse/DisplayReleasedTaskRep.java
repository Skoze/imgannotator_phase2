package wnderful.imgannotator.publicData.response.taskResponse;

import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.DisplayReleasedTaskRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.taskVo.DisplayTaskVo;

public class DisplayReleasedTaskRep extends Response {
    private int code;
    private String message;
    private DisplayTaskVo date;

    public DisplayReleasedTaskRep(DisplayReleasedTaskRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public DisplayReleasedTaskRep(DisplayReleasedTaskRepCode repCode, DisplayTaskVo date) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
        this.date = date;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public DisplayTaskVo getDate() {
        return date;
    }
}
