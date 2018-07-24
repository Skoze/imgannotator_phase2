package wnderful.imgannotator.blserviceImpl;

import wnderful.imgannotator.blservice.UserService;
import wnderful.imgannotator.publicData.response.Response;

public class UserServiceImpl implements UserService {

    @Override
    public Response getUserMessage(String username) {
        return new Response();
    }

    @Override
    public Response updateUserMessage(String username, String newUsername, String newEmail, String oldPassword, String newPassword){
        return new Response();
    }
}
