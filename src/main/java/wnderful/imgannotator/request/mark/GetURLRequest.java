package wnderful.imgannotator.request.mark;

public class GetURLRequest {
    private String taskName;
    private String imgID;

    public GetURLRequest(String taskName, String imgID) {
        this.taskName = taskName;
        this.imgID = imgID;
    }

    public GetURLRequest() {
    }

    public String getTaskName() {
        return taskName;
    }

    public String getImgID() {
        return imgID;
    }
}
