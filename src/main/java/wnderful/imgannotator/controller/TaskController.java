package wnderful.imgannotator.controller;

import org.springframework.web.bind.annotation.*;
import wnderful.imgannotator.blserviceImpl.TaskServiceImpl;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.request.task.*;

@RestController
@RequestMapping(value = "/service/taskManagement")
public class TaskController {

    private final TaskServiceImpl taskService = new TaskServiceImpl();

    @RequestMapping(value = "/requester/add/{username}", method = RequestMethod.POST)
    public Response releaseTask(@PathVariable("username") String username, @RequestBody ReleaseTaskRequest request) {
        return taskService.releaseTask(username, request.getTaskname(), request.getTaskDescription()
                , request.getTaskTime(), request.getTaskTag(), request.getCredits(), request.getMaxWorkers());
    }

    @RequestMapping(value = "/requester/display/releasedTask/{username}", method = RequestMethod.GET)
    public Response displayReleasedTask(@PathVariable("username") String username) {
        return taskService.displayReleasedTask(username);
    }

    @RequestMapping(value = "/requester/modify/{username}", method = RequestMethod.POST)
    public Response modifyTask(@PathVariable("username") String username, @RequestBody ModifyTaskRequest request) {
        return taskService.modifyTask(username, request.getTaskname(), request.getTaskDescription(), request.getRemainTime(),
                request.getTaskTag(), request.getMaxWorkers());
    }

    @RequestMapping(value = "/requester/delete/{username}", method = RequestMethod.POST)
    public Response deleteTask(@PathVariable("username") String username, @RequestBody DeleteTaskRequest request) {
        return taskService.deleteTask(username, request.getTaskname());
    }

    @RequestMapping(value = "/worker/display/receiptTask/{username}", method = RequestMethod.GET)
    public Response displayReceiptTask(@PathVariable("username") String username) {
        return taskService.displayReceiptTask(username);
    }

    @RequestMapping(value = "/worker/receiptTask/{username}", method = RequestMethod.POST)
    public Response receiptTask(@PathVariable("username") String username, @RequestBody ReceiptTaskRequest request) {
        return taskService.receiptTask(username, request.getTaskname());
    }

}
