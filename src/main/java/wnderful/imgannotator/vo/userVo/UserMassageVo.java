package wnderful.imgannotator.vo.userVo;

public class UserMassageVo {
    private String username;
    private String email;
    private int points;
    private String role;

    public UserMassageVo() {
    }

    public UserMassageVo(String username, String email, int points, String role) {
        this.username = username;
        this.email = email;
        this.points = points;
        this.role = role;
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
}
