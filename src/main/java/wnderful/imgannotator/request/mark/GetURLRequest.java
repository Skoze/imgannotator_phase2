package wnderful.imgannotator.request.mark;

public class GetURLRequest {
    private String taskname;

    public GetURLRequest() {
    }

    public GetURLRequest(String username, String taskname) {
        this.taskname = taskname;
    }

    public String getTaskname() {
        return taskname;
    }

}
