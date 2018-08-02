package wnderful.imgannotator.publicData.reponseCode.taskResponseCode;

public enum ReleaseTaskRepCode {

    ALREADYUPLOAD(-1,"任务已发布，积分未扣除"),
    SUCCESS(0,"发布任务成功"),
    FAIL(1,"发布任务失败"),
    NOTFOUND(2,"无此发布者"),
    REPEAT(3,"任务名重复"),
    NOIMG(4,"图片集中未有图片"),
    WRONGDATA(5,"最大工人数至少为1，积分数至少为0，时间至少为1"),
    NOPOINT(6,"积分不足");


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
