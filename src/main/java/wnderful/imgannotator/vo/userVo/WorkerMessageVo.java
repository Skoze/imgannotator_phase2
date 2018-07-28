package wnderful.imgannotator.vo.userVo;

public class WorkerMessageVo extends UserMessageVo {
    private String username;
    private String email;
    private int points;
    private int completedTasks;
    private int completedImages;
    private String role = "worker";

    public WorkerMessageVo() {
        this.username = "";
        this.email = "";
        this.points = -1;
        this.completedTasks = -1;
        this.completedImages = -1;
    }

    public WorkerMessageVo(String username, String email, int points, int completedTasks, int completedImages) {
        this.username = username;
        this.email = email;
        this.points = points;
        this.completedTasks = completedTasks;
        this.completedImages = completedImages;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getPoints() {
        return points;
    }

    public int getCompletedTasks() {
        return completedTasks;
    }

    public int getCompletedImages() {
        return completedImages;
    }

    @Override
    public String getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setCompletedTasks(int completedTasks) {
        this.completedTasks = completedTasks;
    }

    public void setCompletedImages(int completedImages) {
        this.completedImages = completedImages;
    }
}
