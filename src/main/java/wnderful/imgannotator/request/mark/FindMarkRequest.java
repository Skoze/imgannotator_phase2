package wnderful.imgannotator.request.mark;

public class FindMarkRequest {
    private String taskname;
    private String imgID;

    public FindMarkRequest() {
    }

    public FindMarkRequest(String taskname, String imgID) {
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
