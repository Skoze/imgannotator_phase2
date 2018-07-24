package wnderful.imgannotator.request.task;

public class DeleteTaskRequest {
    private String taskname;

    public DeleteTaskRequest() {
    }

    public DeleteTaskRequest( String taskname) {
        this.taskname = taskname;
    }

    public String getTaskname() {
        return taskname;
    }
}
