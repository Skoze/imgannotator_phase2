package wnderful.imgannotator.publicData.reponseCode.markResponseCode;

public enum SetMarkRepCode {
    SUCCESS(0,"提交标记成功"),
    FAIL(1,"提交标记失败");

    private int code;
    private String message;

    SetMarkRepCode(int code, String message) {
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
