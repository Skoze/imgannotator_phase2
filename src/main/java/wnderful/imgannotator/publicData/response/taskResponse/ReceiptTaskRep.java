package wnderful.imgannotator.publicData.response.taskResponse;

import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.ReceiptTaskRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.taskVo.ReceiptTaskVo;

public class ReceiptTaskRep extends Response {
    private int code;
    private String message;
    private ReceiptTaskVo data;

    public ReceiptTaskRep(ReceiptTaskRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public ReceiptTaskRep(ReceiptTaskRepCode repCode,ReceiptTaskVo data) {
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

    public ReceiptTaskVo getData() {
        return data;
    }
}
