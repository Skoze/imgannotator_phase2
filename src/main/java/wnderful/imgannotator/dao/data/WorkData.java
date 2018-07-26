package wnderful.imgannotator.dao.data;

public class WorkData {
    private String workname;
    private String username;
    private String imgname;

    public WorkData() {
    }

    public WorkData(String workname, String username, String imgname) {
        this.workname = workname;
        this.username = username;
        this.imgname = imgname;
    }

    public String getWorkname() {
        return workname;
    }

    public String getUsername() {
        return username;
    }

    public String getImgname() {
        return imgname;
    }

    public void setWorkname(String workname) {
        this.workname = workname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }
}
