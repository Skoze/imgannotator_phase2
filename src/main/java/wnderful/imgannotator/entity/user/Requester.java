package wnderful.imgannotator.entity.user;



public class Requester extends User {
    private int points;
    private int releasedTasks;
    private String role = "requester";

    public Requester() {
        super();
    }

    public Requester(String username, String password, String email, int points) {
        super(username, password, email, "requester");
        this.points = points;
    }

    public Requester(String username, String password, String email, String role, int points, int releasedTasks) {
        super(username, password, email, role);
        this.points = points;
        this.releasedTasks = releasedTasks;
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

    public void setPoints(int points) {
        this.points = points;
    }

    public void setReleasedTasks(int releasedTasks) {
        this.releasedTasks = releasedTasks;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }
}
