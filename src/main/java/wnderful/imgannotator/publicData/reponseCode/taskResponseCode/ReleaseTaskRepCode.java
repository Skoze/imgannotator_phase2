package wnderful.imgannotator.publicData.reponseCode.taskResponseCode;

public enum ReleaseTaskRepCode {

    ALREADYUPLOAD(-1,"任务已发布，积分未扣除"),
    SUCCESS(0,"发布任务成功"),
    FAIL(1,"发布任务失败"),
    NOTFOUND(2,"无此发布者"),
    REPEAT(3,"任务名重复"),
    NOIMG(4,"未创建图片集"),
    NOPOINT(5,"积分不足");


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
