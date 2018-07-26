package wnderful.imgannotator.vo.baseVo;

public class DisplayDetailVo {
      private String taskname;
      private String imgURL;
      private String taskRequestor;
      private String taskStartTime;
      private int numberOfImages;
      private int points;
      private String taskDescription;
      private int remainTime;
      private String[] taskTag;
      private int currentWorker;
      private int maxWorker;
      private WorkerVo[] currentWorkers;

    public DisplayDetailVo() {
        this.taskname = "";
        this.imgURL = "";
        this.taskRequestor = "";
        this.taskStartTime = "";
        this.numberOfImages = -1;
        this.points = -1;
        this.taskDescription = "";
        this.remainTime = -1;
        this.taskTag = new String[0];
        this.currentWorker = -1;
        this.maxWorker = -1;
        this.currentWorkers = new WorkerVo[0];
    }

    public DisplayDetailVo(String taskname, String imgURL, String taskRequestor, String taskStartTime, int numberOfImages,
                           int points, String taskDescription, int remainTime, String[] taskTag, int currentWorker,
                           int maxWorker, WorkerVo[] currentWorkers) {
        this.taskname = taskname;
        this.imgURL = imgURL;
        this.taskRequestor = taskRequestor;
        this.taskStartTime = taskStartTime;
        this.numberOfImages = numberOfImages;
        this.points = points;
        this.taskDescription = taskDescription;
        this.remainTime = remainTime;
        this.taskTag = taskTag;
        this.currentWorker = currentWorker;
        this.maxWorker = maxWorker;
        this.currentWorkers = currentWorkers;
    }

    public String getTaskname() {
        return taskname;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getTaskRequestor() {
        return taskRequestor;
    }

    public String getTaskStartTime() {
        return taskStartTime;
    }

    public int getNumberOfImages() {
        return numberOfImages;
    }

    public int getPoints() {
        return points;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public int getRemainTime() {
        return remainTime;
    }

    public String[] getTaskTag() {
        return taskTag;
    }

    public int getCurrentWorker() {
        return currentWorker;
    }

    public int getMaxWorker() {
        return maxWorker;
    }

    public WorkerVo[] getCurrentWorkers() {
        return currentWorkers;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public void setTaskRequestor(String taskRequestor) {
        this.taskRequestor = taskRequestor;
    }

    public void setTaskStartTime(String taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public void setNumberOfImages(int numberOfImages) {
        this.numberOfImages = numberOfImages;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setRemainTime(int remainTime) {
        this.remainTime = remainTime;
    }

    public void setTaskTag(String[] taskTag) {
        this.taskTag = taskTag;
    }

    public void setCurrentWorker(int currentWorker) {
        this.currentWorker = currentWorker;
    }

    public void setMaxWorker(int maxWorker) {
        this.maxWorker = maxWorker;
    }

    public void setCurrentWorkers(WorkerVo[] currentWorkers) {
        this.currentWorkers = currentWorkers;
    }
}
