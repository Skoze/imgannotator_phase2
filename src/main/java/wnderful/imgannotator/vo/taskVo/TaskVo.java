package wnderful.imgannotator.vo.taskVo;

public class TaskVo {
    private String taskname;
    private String imgURL;
    private int remianTime;
    private String[] taskTag;
    private int cunrentWorker;
    private int maxWorker;

    public TaskVo() {
        this.taskname = "";
        this.imgURL = "";
        this.remianTime = -1;
        this.taskTag = new String[0];
        this.cunrentWorker = 0;
        this.maxWorker = 0;
    }

    public TaskVo(String taskname, String imgURL, int remianTime, String[] taskTag, int cunrentWorker, int maxWorker) {
        this.taskname = taskname;
        this.imgURL = imgURL;
        this.remianTime = remianTime;
        this.taskTag = taskTag;
        this.cunrentWorker = cunrentWorker;
        this.maxWorker = maxWorker;
    }

    public String getTaskname() {
        return taskname;
    }

    public String getImgURL() {
        return imgURL;
    }

    public int getRemianTime() {
        return remianTime;
    }

    public String[] getTaskTag() {
        return taskTag;
    }

    public int getCunrentWorker() {
        return cunrentWorker;
    }

    public int getMaxWorker() {
        return maxWorker;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public void setRemianTime(int remianTime) {
        this.remianTime = remianTime;
    }

    public void setTaskTag(String[] taskTag) {
        this.taskTag = taskTag;
    }

    public void setCunrentWorker(int cunrentWorker) {
        this.cunrentWorker = cunrentWorker;
    }

    public void setMaxWorker(int maxWorker) {
        this.maxWorker = maxWorker;
    }
}
