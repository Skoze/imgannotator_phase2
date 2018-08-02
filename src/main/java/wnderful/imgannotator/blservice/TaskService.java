package wnderful.imgannotator.blservice;

import wnderful.imgannotator.publicData.response.Response;

public interface TaskService {
    Response releaseTask(String username, String taskname, String taskDescription, int taskTime, String[] taskTag, int credits, int maxWorkers);

    Response displayReleasedTask(String username);

    Response modifyTask(String username, String taskname, String taskDescription, int remainTime, String[] taskTag, int maxWorkers);

    Response deleteTask(String username, String taskName);

    Response displayReceiptTask(String username);

    Response receiptTask(String username, String taskName);

}
