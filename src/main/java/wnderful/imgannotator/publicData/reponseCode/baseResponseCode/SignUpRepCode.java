package wnderful.imgannotator.publicData.reponseCode.baseResponseCode;

public enum SignUpRepCode {
    SUCCESS(0,"注册成功"),
    FAIL(1,"注册失败"),
    NAMEREPEAT(2,"用户名重复");

    private int code;
    private String message;

    SignUpRepCode(int code, String message) {
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
