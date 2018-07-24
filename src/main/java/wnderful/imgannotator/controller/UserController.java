package wnderful.imgannotator.controller;

import org.springframework.web.bind.annotation.*;
import wnderful.imgannotator.blserviceImpl.UserServiceImpl;
import wnderful.imgannotator.request.user.UpdateUserRequest;
import wnderful.imgannotator.publicData.response.Response;

@RestController
@RequestMapping(value = "/service/user")
public class UserController {

    final UserServiceImpl userService = new UserServiceImpl();

    @RequestMapping(value = "/getUserMessage/{username}", method = RequestMethod.GET)
    public Response getUserMessage(@PathVariable("username") String username) {
        Response response = userService.getUserMessage(username);
        return response;
    }

    @RequestMapping(value = "/updateUserMessage/{username}", method = RequestMethod.POST)
    public Response updateUserMessage(@PathVariable("username") String username,@RequestBody UpdateUserRequest requst) {
        Response response = userService.updateUserMessage(username,requst.getNewUsername(),requst.getNewEmail(),requst.getOldPassword(),requst.getNewPassword());
        return response;
    }
}
