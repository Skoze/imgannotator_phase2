package wnderful.imgannotator.request.mark;

import com.fasterxml.jackson.databind.util.JSONPObject;

public class ImgMarkRequest {
    private String  taskName;
    private String  imgID;
    private JSONPObject marks;

    public ImgMarkRequest() {
    }

    public ImgMarkRequest(String taskName, String imgID, JSONPObject marks) {
        this.taskName = taskName;
        this.imgID = imgID;
        this.marks = marks;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getImgID() {
        return imgID;
    }

    public JSONPObject getMarks() {
        return marks;
    }
}
