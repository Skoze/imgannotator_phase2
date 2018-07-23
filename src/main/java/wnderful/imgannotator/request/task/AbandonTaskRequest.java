package wnderful.imgannotator.request.task;

public class AbandonTaskRequest {

    private String username;
    private String taskname;

    public AbandonTaskRequest() {
    }

    public AbandonTaskRequest(String username, String taskname) {
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
