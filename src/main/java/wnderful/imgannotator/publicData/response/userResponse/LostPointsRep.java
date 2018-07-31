package wnderful.imgannotator.publicData.response.userResponse;

import wnderful.imgannotator.publicData.reponseCode.userResponseCode.LostPointsRepCode;
import wnderful.imgannotator.publicData.response.Response;

public class LostPointsRep extends Response {
    private int code;
    private String message;

    public LostPointsRep(LostPointsRepCode repCode) {
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
