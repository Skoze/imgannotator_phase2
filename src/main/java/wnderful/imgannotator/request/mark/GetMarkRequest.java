package wnderful.imgannotator.request.mark;

public class GetMarkRequest {
    private String taskname;
    private String imgID;

    public GetMarkRequest(String taskname, String imgID) {
        this.taskname = taskname;
        this.imgID = imgID;
    }

    public GetMarkRequest() {
    }

    public String getTaskname() {
        return taskname;
    }

    public String getImgID() {
        return imgID;
    }
}
