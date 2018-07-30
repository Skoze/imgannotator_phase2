package wnderful.imgannotator.publicData.reponseCode.markResponseCode;

public enum SetMarkRepCode {
    SUCCESS(0,"提交标记成功"),
    FAIL(1,"提交标记失败"),
    NOTFOUND(2,"无此工人"),
    NOTASK(3,"任务未接受"),
    END(4,"任务已结束"),
    NOIMG(5,"无此图片");

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
