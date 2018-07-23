package wnderful.imgannotator.request.task;

public class ReceiptTaskRequest {
    private String username;
    private String taskname;

    public ReceiptTaskRequest() {
    }

    public ReceiptTaskRequest(String username, String taskname) {
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
