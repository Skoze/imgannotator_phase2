package wnderful.imgannotator.request.task;

public class ReleaseTaskRequest {
    private String taskname;
    private String taskDescription;
    private int taskTime;
    private String[] taskTag;
    private int credits;
    private int maxWorkers;

    public ReleaseTaskRequest() {
    }

    public ReleaseTaskRequest(String taskname, String taskDescription, int taskTime, String[] taskTag, int credits, int maxWorkers) {
        this.taskname = taskname;
        this.taskDescription = taskDescription;
        this.taskTime = taskTime;
        this.taskTag = taskTag;
        this.credits = credits;
        this.maxWorkers = maxWorkers;
    }

    public String getTaskname() {
        return taskname;
    }

    public String getTaskDescription() {
        return taskDescription;
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
