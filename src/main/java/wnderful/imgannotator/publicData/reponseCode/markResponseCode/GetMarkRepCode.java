package wnderful.imgannotator.publicData.reponseCode.markResponseCode;

public enum GetMarkRepCode {
    SUCCESS(0,"获取未完成图片标记成功"),
    FAIL(1,"获取未完成图片标记失败"),
    NOTFOUND(2,"无此工人"),
    NOTASK(3,"任务未接受"),
    END(4,"任务已结束"),
    NOIMG(5,"无此图片"),
    COMPLETE(6,"图片已完成"),
    NOMARK(7,"图片未标记");

    private int code;
    private String message;

    GetMarkRepCode(int code, String message) {
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
