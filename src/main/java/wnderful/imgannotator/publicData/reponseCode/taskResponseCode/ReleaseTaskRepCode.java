package wnderful.imgannotator.publicData.reponseCode.taskResponseCode;

public enum ReleaseTaskRepCode {

    SUCCESS(0,"发布任务成功"),
    FAIL(1,"发布任务失败");

    private int code;
    private String message;

    ReleaseTaskRepCode(int code, String message) {
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
