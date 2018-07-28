package wnderful.imgannotator.publicData.reponseCode.taskResponseCode;

public enum ModifyTaskRepCode {

    SUCCESS(0,"修改任务成功"),
    FAIL(1,"修改任务失败"),
    NOTFOUND(2,"无此发布者"),
    NOTASK(3,"无发布任务");

    private int code;
    private String message;

    ModifyTaskRepCode(int code, String message) {
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