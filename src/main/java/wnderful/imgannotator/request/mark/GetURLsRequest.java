package wnderful.imgannotator.request.mark;

public class GetURLsRequest {
    private String taskname;

    public GetURLsRequest() {
    }

    public GetURLsRequest(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskname() {
        return taskname;
    }
}
