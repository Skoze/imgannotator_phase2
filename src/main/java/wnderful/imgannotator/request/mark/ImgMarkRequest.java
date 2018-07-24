package wnderful.imgannotator.request.mark;

import com.alibaba.fastjson.*;

public class ImgMarkRequest {
    private String taskname;
    private String imgID;
    private JSONPObject marks;

    public ImgMarkRequest() {
    }

    public ImgMarkRequest(String taskname, String imgID, JSONPObject marks) {
        this.taskname = taskname;
        this.imgID = imgID;
        this.marks = marks;
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
