package wnderful.imgannotator.controller;

import org.springframework.web.bind.annotation.*;
import wnderful.imgannotator.publicData.Response;
import wnderful.imgannotator.request.task.DeleteTaskRequest;
import wnderful.imgannotator.request.task.ModifyTaskRequest;
import wnderful.imgannotator.request.task.ReleaseTaskRequest;

@RestController
@RequestMapping(value = "/taskManagement")
public class TaskController {

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Response releaseTask(@RequestBody ReleaseTaskRequest request){
        return new Response();
    }

    @RequestMapping(value = "/display/detail/{taskName}",method = RequestMethod.GET)
    public Response displayDetail(@PathVariable("taskName") String taskName){
        return new Response();
    }

    @RequestMapping(value = "/display/releasedTask",method = RequestMethod.GET)
    public Response displayReleasedTask(){
        return new Response();
    }

    @RequestMapping(value = "/amodify",method = RequestMethod.POST)
    public Response modifyTask(@RequestBody ModifyTaskRequest request){
        return new Response();
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Response deleteTask(@RequestBody DeleteTaskRequest request){
        return new Response();
    }

}
