package wnderful.imgannotator.request.user;

public class UpdateUserRequest {
    private String username;
    private String email;
    private String oldPassword;
    private String newPassword;

    public UpdateUserRequest(String username, String email, String oldPassword, String newPassword) {
        this.username = username;
        this.email = email;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getOldPassword() {
        return this.oldPassword;
    }

    public String getNewPassword() {
        return this.newPassword;
    }

}
