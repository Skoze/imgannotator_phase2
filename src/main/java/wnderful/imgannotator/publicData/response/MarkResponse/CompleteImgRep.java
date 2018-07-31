package wnderful.imgannotator.publicData.response.MarkResponse;

import wnderful.imgannotator.publicData.reponseCode.markResponseCode.CompleteImgRepCode;
import wnderful.imgannotator.publicData.response.Response;

public class CompleteImgRep extends Response {
    private int code;
    private String message;

    public CompleteImgRep(CompleteImgRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
