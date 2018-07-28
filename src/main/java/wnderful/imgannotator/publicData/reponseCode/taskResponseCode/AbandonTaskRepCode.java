package wnderful.imgannotator.publicData.reponseCode.taskResponseCode;

public enum AbandonTaskRepCode {

    SUCCESS(0,"放弃任务成功"),
    FAIL(1,"放弃任务失败"),
    NOTFOUND(2,"无此工人"),
    NOTASK(3,"任务未接受");

    private int code;
    private String message;

    AbandonTaskRepCode(int code, String message) {
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
