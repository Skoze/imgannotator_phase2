package wnderful.imgannotator.vo.userVo;

public class RequesterMessageVo extends UserMessageVo{
    private String username;
    private String email;
    private int points;
    private int releasedTasks;
    private String role = "requester";

    public RequesterMessageVo() {
        this.username = "";
        this.email = "";
        this.points = -1;
        this.releasedTasks = -1;
    }

    public RequesterMessageVo(String username, String email, int points, int releasedTasks) {
        this.username = username;
        this.email = email;
        this.points = points;
        this.releasedTasks = releasedTasks;
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

    public int getReleasedTasks() {
        return releasedTasks;
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

    public void setReleasedTasks(int releasedTasks) {
        this.releasedTasks = releasedTasks;
    }
}
