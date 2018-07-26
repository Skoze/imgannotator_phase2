package wnderful.imgannotator.publicData.reponseCode.userResponseCode;

public enum UpdateUserMessageRepCode {
    SUCCESS(0,"更新用户信息成功"),
    FAIL(1,"更新用户信息失败");

    private int code;
    private String message;

    UpdateUserMessageRepCode(int code, String message) {
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
