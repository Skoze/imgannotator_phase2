package wnderful.imgannotator.request.mark;

import com.alibaba.fastjson.*;

public class ImgMarkRequest {
    private String  username;
    private String  taskname;
    private String  imgID;
    private JSONPObject marks;

    public ImgMarkRequest() {
    }

    public ImgMarkRequest(String username, String taskname, String imgID, JSONPObject marks) {
        this.username = username;
        this.taskname = taskname;
        this.imgID = imgID;
        this.marks = marks;
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

    public JSONPObject getMarks() {
        return marks;
    }
}
