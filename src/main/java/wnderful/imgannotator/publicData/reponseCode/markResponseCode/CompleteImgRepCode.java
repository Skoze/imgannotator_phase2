package wnderful.imgannotator.publicData.reponseCode.markResponseCode;

public enum CompleteImgRepCode {
    SUCCESS(0,"完成图片成功"),
    FAIL(1,"完成图片失败"),
    NOTFOUND(2,"无此工人"),
    NOTASK(3,"任务未接受"),
    END(4,"任务已结束"),
    NOIMG(5,"无此图片"),
    NOMARK(6,"图片未标记"),
    COMPLETE(7,"图片已完成标记");


    private int code;
    private String message;

    CompleteImgRepCode(int code, String message) {
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
