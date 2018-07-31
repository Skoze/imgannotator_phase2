package wnderful.imgannotator.request.mark;

public class CompleteImgRequest {
    private String taskname;
    private String imgID;

    public CompleteImgRequest() {
    }

    public CompleteImgRequest(String taskname, String imgID) {
        this.taskname = taskname;
        this.imgID = imgID;
    }

    public String getTaskname() {
        return taskname;
    }

    public String getImgID() {
        return imgID;
    }
}
