package wnderful.imgannotator.publicData.reponseCode.markResponseCode;

public enum FindMarkRepCode {
    SUCCESS(0,"查找图片标记成功"),
    FAIL(1,"查找图片标记失败"),
    NOTFOUND(2,"未找到发起者"),
    NOTALLOW(3,"无查看权限");

    private int code;
    private String message;

    FindMarkRepCode(int code, String message) {
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