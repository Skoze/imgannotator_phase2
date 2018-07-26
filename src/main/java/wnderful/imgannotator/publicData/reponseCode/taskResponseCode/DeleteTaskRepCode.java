package wnderful.imgannotator.publicData.reponseCode.taskResponseCode;

public enum DeleteTaskRepCode {

    SUCCESS(0,"结束任务成功"),
    FAIL(1,"结束任务失败");

    private int code;
    private String message;

    DeleteTaskRepCode(int code, String message) {
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
