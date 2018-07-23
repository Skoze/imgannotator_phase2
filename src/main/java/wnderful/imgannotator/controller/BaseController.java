package wnderful.imgannotator.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wnderful.imgannotator.publicData.Response;
import wnderful.imgannotator.request.base.*;

@RestController
@RequestMapping(value = "/base")
public class BaseController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestBody LoginRequest request) {
        return new Response();
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public Response signUp(@RequestBody SignUpRequest requestt) {
        return new Response();
    }

    @RequestMapping(value = "/display/detail/{taskName}",method = RequestMethod.GET)
    public Response displayDetail(@PathVariable("taskName") String taskName){
        return new Response();
    }

    @RequestMapping(value = "/display/allTask",method = RequestMethod.GET)
    public Response displayAllTask(){
        return new Response();
    }
}
