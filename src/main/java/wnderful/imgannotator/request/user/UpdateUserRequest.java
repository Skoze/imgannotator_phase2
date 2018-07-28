package wnderful.imgannotator.request.user;

public class UpdateUserRequest {
    private String newEmail;
    private String oldPassword;
    private String newPassword;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(String newEmail, String oldPassword, String newPassword) {
        this.newEmail = newEmail;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
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
