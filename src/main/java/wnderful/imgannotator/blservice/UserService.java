package wnderful.imgannotator.blservice;

import wnderful.imgannotator.publicData.response.Response;

public interface UserService {
     Response getUserMessage(String username);

     Response updateUserMessage(String username, String newUsername, String newEmail, String oldPassword, String newPassword);
}
