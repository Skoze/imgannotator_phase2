package wnderful.imgannotator.request.user;

public class GetUserMessageRequest {
    private String username;

    public GetUserMessageRequest() {
    }

    public GetUserMessageRequest(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
