package wnderful.imgannotator.publicData.requestCode;

public enum LoginReqCode {

    SUCCESS(0,"登陆成功"),
    FAIL(1,"登录失败");

    private int code;
    private String message;

    LoginReqCode(int code, String message) {
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
