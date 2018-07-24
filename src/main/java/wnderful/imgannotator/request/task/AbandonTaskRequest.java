package wnderful.imgannotator.request.task;

public class AbandonTaskRequest {

    private String taskname;

    public AbandonTaskRequest() {
    }

    public AbandonTaskRequest(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskname() {
        return taskname;
    }
}
