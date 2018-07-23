package wnderful.imgannotator.request.mark;

public class GetURLRequest {
    private String username;
    private String taskname;
    private String imgID;

    public GetURLRequest() {
    }

    public GetURLRequest(String username, String taskname, String imgID) {
        this.username = username;
        this.taskname = taskname;
        this.imgID = imgID;
    }

    public String getUsername() {
        return username;
    }

    public String getTaskname() {
        return taskname;
    }

    public String getImgID() {
        return imgID;
    }
}
