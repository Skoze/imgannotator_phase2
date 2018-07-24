package wnderful.imgannotator.request.user;

public class UpdateUserRequest {
    private String newUsername;
    private String newEmail;
    private String oldPassword;
    private String newPassword;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(String newUsername, String newEmail, String oldPassword, String newPassword) {
        this.newUsername = newUsername;
        this.newEmail = newEmail;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
