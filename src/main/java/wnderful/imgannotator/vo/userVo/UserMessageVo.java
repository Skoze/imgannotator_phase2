package wnderful.imgannotator.vo.userVo;

public class UserMessageVo {
    private String username;
    private String email;
    private int points;
    private String role;
    private int releasedTasks;
    private int completedTasks;
    private int completedImages;

    public UserMessageVo() {
        this.username = "";
        this.email = "";
        this.points = -1;
        this.role = "";
        this.releasedTasks = -1;
        this.completedTasks = -1;
        this.completedImages = -1;
    }

    public UserMessageVo(String username, String email, int points, String role, int releasedTasks, int completedTasks, int completedImages) {
        this.username = username;
        this.email = email;
        this.points = points;
        this.role = role;
        this.releasedTasks = releasedTasks;
        this.completedTasks = completedTasks;
        this.completedImages = completedImages;
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

    public void setRole(String role) {
        this.role = role;
    }

    public void setReleasedTasks(int releasedTasks) {
        this.releasedTasks = releasedTasks;
    }

    public void setCompletedTasks(int completedTasks) {
        this.completedTasks = completedTasks;
    }

    public void setCompletedImages(int completedImages) {
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

    public String getRole() {
        return role;
    }

    public int getReleasedTasks() {
        return releasedTasks;
    }

    public int getCompletedTasks() {
        return completedTasks;
    }

    public int getCompletedImages() {
        return completedImages;
    }
}
