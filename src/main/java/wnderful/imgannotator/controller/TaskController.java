package wnderful.imgannotator.controller;

import org.springframework.web.bind.annotation.*;
import wnderful.imgannotator.blserviceImpl.TaskServiceImpl;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.request.task.*;

@RestController
@RequestMapping(value = "/service/taskManagement")
public class TaskController {

    final TaskServiceImpl taskService = new TaskServiceImpl();

    @RequestMapping(value = "/requester/add/{username}", method = RequestMethod.POST)
    public Response releaseTask(@PathVariable("username") String username, @RequestBody ReleaseTaskRequest request) {
        Response response = taskService.releaseTask(username, request.getTaskname(), request.getTaskDescription(),
                request.getImages(), request.getTaskTime(), request.getTaskTag(), request.getCredits(), request.getMaxWorkers());
        return response;
    }

    @RequestMapping(value = "/requester/display/releasedTask/{username}", method = RequestMethod.GET)
    public Response displayReleasedTask(@PathVariable("username") String username) {
        Response response = taskService.displayReleasedTask(username);
        return response;
    }

    @RequestMapping(value = "/requester/modify/{username}", method = RequestMethod.POST)
    public Response modifyTask(@PathVariable("username") String username, @RequestBody ModifyTaskRequest request) {
        Response response = taskService.modifyTask(username, request.getTaskname(), request.getTaskDescription(), request.getRemainTime(),
                request.getTaskTag(), request.getMaxWorkers());
        return response;
    }

    @RequestMapping(value = "/requester/delete/{username}", method = RequestMethod.POST)
    public Response deleteTask(@PathVariable("username") String username, @RequestBody DeleteTaskRequest request) {
        Response response = taskService.deleteTask(username, request.getTaskname());
        return response;
    }

    @RequestMapping(value = "/worker/display/receiptTask/{username}", method = RequestMethod.GET)
    public Response displayReceiptTask(@PathVariable("username") String username) {
        Response response = taskService.displayReceiptTask(username);
        return response;
    }

    @RequestMapping(value = "/worker/receiptTask/{username}", method = RequestMethod.POST)
    public Response receiptTask(@PathVariable("username") String username, @RequestBody ReceiptTaskRequest request) {
        Response response = taskService.receiptTask(username, request.getTaskname());
        return response;
    }


    @RequestMapping(value = "/worker/abandon/{username}", method = RequestMethod.POST)
    public Response abandonTask(@PathVariable("username") String username, @RequestBody AbandonTaskRequest request) {
        Response response = taskService.abandonTask(username, request.getTaskname());
        return response;
    }

}
