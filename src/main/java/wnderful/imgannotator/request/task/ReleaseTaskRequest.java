package wnderful.imgannotator.request.task;

public class ReleaseTaskRequest {
    private String taskName;
    private String taskDescription;
    private String images;
    private int taskTime;
    private String[] taskTag;
    private int credits;
    private int maxWorkers;

    public ReleaseTaskRequest() {
    }

    public ReleaseTaskRequest(String taskName, String taskDescription, String images, int taskTime, String[] taskTag, int credits, int maxWorkers) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.images = images;
        this.taskTime = taskTime;
        this.taskTag = taskTag;
        this.credits = credits;
        this.maxWorkers = maxWorkers;
    }

    public String getTaskName() {
        return taskName;
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
