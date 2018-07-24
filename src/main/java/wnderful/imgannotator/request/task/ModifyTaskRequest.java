package wnderful.imgannotator.request.task;

public class ModifyTaskRequest {
    private String taskname;
    private String taskDescription;
    private int remainTime;
    private String[] taskTag;
    private int maxWorkers;

    public ModifyTaskRequest() {
    }

    public ModifyTaskRequest(String taskname, String taskDescription, int remainTime, String[] taskTag, int maxWorkers) {
        this.taskname = taskname;
        this.taskDescription = taskDescription;
        this.remainTime = remainTime;
        this.taskTag = taskTag;
        this.maxWorkers = maxWorkers;
    }

    public String getTaskname() {
        return taskname;
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
