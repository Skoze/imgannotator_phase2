package wnderful.imgannotator.controller;

import org.springframework.web.bind.annotation.*;
import wnderful.imgannotator.publicData.Response;
import wnderful.imgannotator.request.task.*;

@RestController
@RequestMapping(value = "/service/taskManagement")
public class TaskController {

    @RequestMapping(value = "/requester/add",method = RequestMethod.POST)
    public Response releaseTask(@RequestBody ReleaseTaskRequest request){
        return new Response();
    }

    @RequestMapping(value = "/requester/display/releasedTask",method = RequestMethod.POST)
    public Response displayReleasedTask(@RequestBody DisplayReleasedTaskRequest request){
        return new Response();
    }

    @RequestMapping(value = "/requester/modify",method = RequestMethod.POST)
    public Response modifyTask(@RequestBody ModifyTaskRequest request){
        return new Response();
    }

    @RequestMapping(value = "/requester/delete",method = RequestMethod.POST)
    public Response deleteTask(@RequestBody DeleteTaskRequest request){
        return new Response();
    }

    @RequestMapping(value = "/worker/display/receiptTask",method = RequestMethod.POST)
    public Response displayReceiptTask(@RequestBody DisplayReceiptTaskRequest request){
        return new Response();
    }

    @RequestMapping(value = "/worker/receiptTask",method = RequestMethod.POST)
    public Response receiptTask(@RequestBody ReceiptTaskRequest request){
        return new Response();
    }


    @RequestMapping(value = "/worker/abandon",method = RequestMethod.POST)
    public Response abandonTask(@RequestBody AbandonTaskRequest request){
        return new Response();
    }

}
