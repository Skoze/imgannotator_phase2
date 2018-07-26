package wnderful.imgannotator.publicData.reponseCode.markResponseCode;

public enum FindURLRepCode {
    SUCCESS(0,"查找图片成功"),
    FAIL(1,"查找图片失败");

    private int code;
    private String message;

    FindURLRepCode(int code, String message) {
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
