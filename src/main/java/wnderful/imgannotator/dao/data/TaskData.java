package wnderful.imgannotator.dao.data;

public class TaskData {
    private String taskname;
    private String requestername;
    private String taskDescription;
    private String[] images;
    private int numberOfImages;
    private String releasedTime;
    private int taskTime;
    private String[] taskTag;
    private int credits;
    private int maxWorkers;
    private int recentWorkers;

    public TaskData() {
    }

    public TaskData(String taskname, String requestername, String taskDescription, String[] images, int numberOfImages, String releasedTime,
                    int taskTime, String[] taskTag, int credits, int maxWorkers, int recentWorkers) {
        this.taskname = taskname;
        this.requestername = requestername;
        this.taskDescription = taskDescription;
        this.images = images;
        this.numberOfImages = numberOfImages;
        this.releasedTime = releasedTime;
        this.taskTime = taskTime;
        this.taskTag = taskTag;
        this.credits = credits;
        this.maxWorkers = maxWorkers;
        this.recentWorkers = recentWorkers;
    }

    public String getTaskname() {
        return taskname;
    }

    public String getRequestername() {
        return requestername;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String[] getImages() {
        return images;
    }

    public int getNumberOfImages() {
        return numberOfImages;
    }

    public String getReleasedTime() {
        return releasedTime;
    }

    public int getTaskTime() {
        return taskTime;
    }

    public String[] getTaskTag() {
        return taskTag;
    }

    public int getCredits() {
        return credits;
    }

    public int getMaxWorkers() {
        return maxWorkers;
    }

    public int getRecentWorkers() {
        return recentWorkers;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public void setRequestername(String requestername) {
        this.requestername = requestername;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public void setNumberOfImages(int numberOfImages) {
        this.numberOfImages = numberOfImages;
    }

    public void setReleasedTime(String releasedTime) {
        this.releasedTime = releasedTime;
    }

    public void setTaskTime(int taskTime) {
        this.taskTime = taskTime;
    }

    public void setTaskTag(String[] taskTag) {
        this.taskTag = taskTag;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setMaxWorkers(int maxWorkers) {
        this.maxWorkers = maxWorkers;
    }

    public void setRecentWorkers(int recentWorkers) {
        this.recentWorkers = recentWorkers;
    }
}
