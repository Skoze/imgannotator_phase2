package wnderful.imgannotator.publicData.reponseCode.taskResponseCode;

public enum DisplayReceiptTaskRepCode {

    SUCCESS(0,"查询已接受任务成功"),
    FAIL(1,"查询已接受任务失败"),
    NOTFOUND(2,"无此工人"),
    NOTASK(3,"无接受任务");

    private int code;
    private String message;

    DisplayReceiptTaskRepCode(int code, String message) {
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