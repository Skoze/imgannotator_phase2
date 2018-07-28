package wnderful.imgannotator.entity.user;

public class User {
    private String username;
    private String password;
    private String email;
    private String role;

    public User() {
        this.username = "test";
        this.email = "test@test.com";
        this.password = "123456";
        this.role = "worker";
    }

    public User(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
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

}
