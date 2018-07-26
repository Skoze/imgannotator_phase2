package wnderful.imgannotator.entity;

public class User {
    private String username;
    private String password;
    private String email;
    private String role;
    private int points;

    public User() {
    }

    public User(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.points = 0;
    }

    public User(String username, String password, String email, String role, int points) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public int getPoints() {
        return points;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
