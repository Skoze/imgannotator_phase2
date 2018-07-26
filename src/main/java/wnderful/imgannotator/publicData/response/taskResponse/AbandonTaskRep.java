package wnderful.imgannotator.publicData.response.taskResponse;

import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.*;
import wnderful.imgannotator.publicData.response.Response;

public class AbandonTaskRep extends Response {
    private int code;
    private String message;

    public AbandonTaskRep(AbandonTaskRepCode repCode) {
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
