package wnderful.imgannotator.publicData.reponseCode.baseResponseCode;

public enum LoginRepCode {

    UNKNOW(-1,"未知错误"),
    SUCCESS(0,"登陆成功"),
    FAIL(1,"登录失败"),
    NOTEXIST(2,"用户不存在");

    private int code;
    private String message;

    LoginRepCode(int code, String message) {
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
