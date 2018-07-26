package wnderful.imgannotator.dao.data;

public class ImgData {
    private String imgname;
    private String imgID;
    private String imgURL;
    private String taskname;

    public ImgData() {
    }

    public ImgData(String imgname, String imgID, String imgURL, String taskname) {
        this.imgname = imgname;
        this.imgID = imgID;
        this.imgURL = imgURL;
        this.taskname = taskname;
    }

    public String getImgname() {
        return imgname;
    }

    public String getImgID() {
        return imgID;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public void setImgID(String imgID) {
        this.imgID = imgID;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }
}
