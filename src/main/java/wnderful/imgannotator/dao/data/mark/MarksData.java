package wnderful.imgannotator.dao.data.mark;

import com.alibaba.fastjson.JSONObject;

public class MarksData {
    private String marksname;
    private String workername;
    private String imgname;
    private String marks;

    public MarksData() {
    }

    public MarksData(String marksname, String workername, String imgname, String marks) {
        this.marksname = marksname;
        this.workername = workername;
        this.imgname = imgname;
        this.marks = marks;
    }

    public String getMarksname() {
        return marksname;
    }

    public String getWorkername() {
        return workername;
    }

    public String getImgname() {
        return imgname;
    }

    public String  getMarks() {
        return marks;
    }

    public void setMarksname(String marksname) {
        this.marksname = marksname;
    }

    public void setWorkername(String workername) {
        this.workername = workername;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public void setMarks(String  marks) {
        this.marks = marks;
    }
}
