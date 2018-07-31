package wnderful.imgannotator.publicData.reponseCode.userResponseCode;

public enum AddPointsRepCode {
    SUCCESS(0,"积分增加成功"),
    FAIL(1,"积分增加失败"),
    NOTFOUND(2,"用户不存在"),
    UNPROPER(3,"增加积分必须大于零");

    private int code;
    private String message;

    AddPointsRepCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
