package wnderful.imgannotator.publicData.reponseCode.uploadResponseCode;

public enum UploadRepCode {
    SUCCESS(0,"图片上传成功"),
    FAIL(1,"图片上传失败");

    private int code;
    private String message;

    UploadRepCode(int code, String message) {
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
