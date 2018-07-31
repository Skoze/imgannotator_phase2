package wnderful.imgannotator.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wnderful.imgannotator.blserviceImpl.BaseServiceImpl;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.request.base.*;

@RestController
@RequestMapping(value = "/base")
public class BaseController {

    private final BaseServiceImpl baseService = new BaseServiceImpl();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestBody LoginRequest request) {
        return baseService.login(request.getUsername(), request.getPassword());
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public Response signUp(@RequestBody SignUpRequest request) {
        return baseService.signUp(request.getUsername(), request.getPassword(), request.getEmail(),request.getRole());
    }

    @RequestMapping(value = "/display/detail/{taskName}", method = RequestMethod.GET)
    public Response displayDetail(@PathVariable("taskName") String taskName) {
        return baseService.displayDetail(taskName);
    }

    @RequestMapping(value = "/display/allTask", method = RequestMethod.GET)
    public Response displayAllTask() {
        return baseService.displayAllTask();
    }
}
