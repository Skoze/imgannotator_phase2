package wnderful.imgannotator.blservice;

import wnderful.imgannotator.publicData.response.Response;

public interface TaskService {
    public Response releaseTask(String username, String taskname, String taskDescription, String[] images,int numberOfImages, int taskTime, String[] taskTag, int credits, int maxWorkers);

    public Response displayReleasedTask(String username);

    public Response modifyTask(String username, String taskname, String taskDescription, int remainTime, String[] taskTag, int maxWorkers);


    public Response deleteTask(String username, String taskName);

    public Response displayReceiptTask(String username);

    public Response receiptTask(String username, String taskName);


    public Response abandonTask(String username, String taskName);
}
