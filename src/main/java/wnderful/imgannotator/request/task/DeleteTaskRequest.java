package wnderful.imgannotator.request.task;

public class DeleteTaskRequest {
    private String username;
    private String taskname;

    public DeleteTaskRequest() {
    }

    public DeleteTaskRequest(String username, String taskname) {
        this.username = username;
        this.taskname = taskname;
    }

    public String getUsername() {
        return username;
    }

    public String getTaskname() {
        return taskname;
    }
}
