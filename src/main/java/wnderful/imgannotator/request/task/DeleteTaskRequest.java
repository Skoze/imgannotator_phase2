package wnderful.imgannotator.request.task;

public class DeleteTaskRequest {
    private String taskName;

    public DeleteTaskRequest(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }
}
