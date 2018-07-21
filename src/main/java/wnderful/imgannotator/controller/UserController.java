package wnderful.imgannotator.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wnderful.imgannotator.request.user.LoginRequest;
import wnderful.imgannotator.request.user.SignUpRequest;
import wnderful.imgannotator.request.user.UpdateUserRequest;
import wnderful.imgannotator.publicData.Response;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestBody LoginRequest request) {
        return new Response();
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public Response signUp(@RequestBody SignUpRequest requestt) {
        return new Response();
    }

    @RequestMapping(value = "/getUserMessage", method = RequestMethod.GET)
    public Response getUserMessage() {
        return new Response();
    }

    @RequestMapping(value = "/updateUserMessage", method = RequestMethod.POST)
    public Response updateUserMessage(@RequestBody UpdateUserRequest requst) {
        return new Response();
    }
}
