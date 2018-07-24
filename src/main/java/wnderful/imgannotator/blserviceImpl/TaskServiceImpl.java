package wnderful.imgannotator.blserviceImpl;

import wnderful.imgannotator.blservice.TaskService;
import wnderful.imgannotator.publicData.response.Response;

public class TaskServiceImpl implements TaskService {

    @Override
    public Response releaseTask(String username, String taskname, String taskDescription, String images, int taskTime, String[] taskTag, int credits, int maxWorkers) {
        return new Response();
    }

    @Override
    public Response displayReleasedTask(String username) {
        return new Response();
    }

    @Override
    public Response modifyTask(String username, String taskname, String taskDescription, int remainTime, String[] taskTag, int maxWorkers) {
        return new Response();
    }

    @Override
    public Response deleteTask(String username, String taskName) {
        return new Response();
    }

    @Override
    public Response displayReceiptTask(String username) {
        return new Response();
    }

    @Override
    public Response receiptTask(String username, String taskName) {
        return new Response();
    }


    @Override
    public Response abandonTask(String username, String taskName) {
        return new Response();
    }
}
