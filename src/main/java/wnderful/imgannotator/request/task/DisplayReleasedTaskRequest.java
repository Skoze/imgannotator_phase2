package wnderful.imgannotator.request.task;

public class DisplayReleasedTaskRequest {

    private String username;

    public DisplayReleasedTaskRequest() {
    }

    public DisplayReleasedTaskRequest(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
