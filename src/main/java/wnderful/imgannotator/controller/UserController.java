package wnderful.imgannotator.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wnderful.imgannotator.request.user.GetUserMessageRequest;
import wnderful.imgannotator.request.user.UpdateUserRequest;
import wnderful.imgannotator.publicData.Response;

@RestController
@RequestMapping(value = "/service/user")
public class UserController {

    @RequestMapping(value = "/getUserMessage", method = RequestMethod.POST)
    public Response getUserMessage(@RequestBody GetUserMessageRequest request) {
        return new Response();
    }

    @RequestMapping(value = "/updateUserMessage", method = RequestMethod.POST)
    public Response updateUserMessage(@RequestBody UpdateUserRequest requst) {
        return new Response();
    }
}
