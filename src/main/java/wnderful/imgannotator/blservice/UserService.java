package wnderful.imgannotator.blservice;

import wnderful.imgannotator.publicData.response.Response;

public interface UserService {
     Response getUserMessage(String username,String role);

     Response updateUserMessage(String username, String newEmail, String oldPassword, String newPassword,String role);
}
