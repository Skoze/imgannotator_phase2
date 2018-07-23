package wnderful.imgannotator.request.task;

public class ReleaseTaskRequest {
    private String username;
    private String taskname;
    private String taskDescription;
    private String images;
    private int taskTime;
    private String[] taskTag;
    private int credits;
    private int maxWorkers;

    public ReleaseTaskRequest() {
    }

    public ReleaseTaskRequest(String username, String taskname, String taskDescription, String images, int taskTime, String[] taskTag, int credits, int maxWorkers) {
        this.username = username;
        this.taskname = taskname;
        this.taskDescription = taskDescription;
        this.images = images;
        this.taskTime = taskTime;
        this.taskTag = taskTag;
        this.credits = credits;
        this.maxWorkers = maxWorkers;
    }

    public String getUsername() {
        return username;
    }

    public String getTaskname() {
        return taskname;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getImages() {
        return images;
    }

    public int getTaskTime() { return taskTime; }

    public String[] getTaskTag() {
        return taskTag;
    }

    public int getCredits() {
        return credits;
    }

    public int getMaxWorkers() {
        return maxWorkers;
    }
}
