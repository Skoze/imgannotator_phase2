package wnderful.imgannotator.publicData.response.taskResponse;

import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.DisplayReceiptTaskRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.taskVo.DisplayReceiptTaskVo;

public class DisplayReceiptTaskRep extends Response {
    private int code;
    private String message;
    private DisplayReceiptTaskVo data;

    public DisplayReceiptTaskRep(DisplayReceiptTaskRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public DisplayReceiptTaskRep(DisplayReceiptTaskRepCode repCode,DisplayReceiptTaskVo data) {
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

    public DisplayReceiptTaskVo getVo() {
        return data;
    }
}
