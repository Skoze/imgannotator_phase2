package wnderful.imgannotator.request.task;

public class DisplayReceiptTaskRequest {

    public String username;

    public DisplayReceiptTaskRequest() {
    }

    public DisplayReceiptTaskRequest(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
