package wnderful.imgannotator.request.task;

public class ModifyTaskRequest {
    private String taskName;
    private String taskDescription;
    private int remainTime;
    private String[] taskTag;
    private int maxWorkers;

    public ModifyTaskRequest(String taskName, String taskDescription, int remainTime, String[] taskTag, int maxWorkers) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.remainTime = remainTime;
        this.taskTag = taskTag;
        this.maxWorkers = maxWorkers;
    }

    public String getTaskName() {
        return taskName;
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

    public int getMaxWorkers() {
        return maxWorkers;
    }
}
