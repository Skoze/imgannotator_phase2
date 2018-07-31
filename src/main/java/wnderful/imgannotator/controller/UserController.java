package wnderful.imgannotator.controller;

import org.springframework.web.bind.annotation.*;
import wnderful.imgannotator.blserviceImpl.UserServiceImpl;
import wnderful.imgannotator.request.user.ModifyPointRequest;
import wnderful.imgannotator.request.user.UpdateUserRequest;
import wnderful.imgannotator.publicData.response.Response;

@RestController
@RequestMapping(value = "/service/user")
public class UserController {

    private final UserServiceImpl userService = new UserServiceImpl();

    @RequestMapping(value = "/worker/getUserMessage/{username}", method = RequestMethod.GET)
    public Response getWorkerMessage(@PathVariable("username") String username) {
        return userService.getUserMessage(username,"worker");
    }

    @RequestMapping(value = "/requester/getUserMessage/{username}", method = RequestMethod.GET)
    public Response getRequesterMessage(@PathVariable("username") String username) {
        return userService.getUserMessage(username,"requester");
    }

    @RequestMapping(value = "/updateUserMessage/{username}", method = RequestMethod.POST)
    public Response updateUserMessage(@PathVariable("username") String username,@RequestBody UpdateUserRequest requst) {
        return userService.updateUserMessage(username,requst.getNewEmail(),requst.getOldPassword(),requst.getNewPassword(),requst.getRole());
    }

    @RequestMapping(value = "/addPoints/{username}",method = RequestMethod.POST)
    public Response addPoints(@PathVariable("username") String username, @RequestBody ModifyPointRequest request){
        return userService.addPoints(username,request.getPoints());
    }

    @RequestMapping(value = "/lostPoints/{username}",method = RequestMethod.POST)
    public Response lostPoints(@PathVariable("username") String username, @RequestBody ModifyPointRequest request){
        return userService.lostPoints(username,request.getPoints());
    }
}
