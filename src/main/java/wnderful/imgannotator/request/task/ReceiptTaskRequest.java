package wnderful.imgannotator.request.task;

public class ReceiptTaskRequest {
    private String taskname;

    public ReceiptTaskRequest() {
    }

    public ReceiptTaskRequest(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskname() {
        return taskname;
    }
}
