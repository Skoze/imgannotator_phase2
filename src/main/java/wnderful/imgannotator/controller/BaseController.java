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

    final BaseServiceImpl baseService = new BaseServiceImpl();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestBody LoginRequest request) {
        Response response = baseService.login(request.getUsername(),request.getPassword());
        return response;
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public Response signUp(@RequestBody SignUpRequest requestt) {
        Response response = baseService.signUp(requestt.getUsername(),requestt.getPassword(),requestt.getEmail());
        return response;
    }

    @RequestMapping(value = "/display/detail/{taskName}",method = RequestMethod.GET)
    public Response displayDetail(@PathVariable("taskName") String taskName){
        Response response = baseService.displayDetail(taskName);
        return response;
    }

    @RequestMapping(value = "/display/allTask",method = RequestMethod.GET)
    public Response displayAllTask(){
        Response response = baseService.displayAllTask();
        return response;
    }
}
