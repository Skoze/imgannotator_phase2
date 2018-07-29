package wnderful.imgannotator.util;

import wnderful.imgannotator.dao.data.TaskData;
import wnderful.imgannotator.dataServiceImpl.UserDataServiceImpl;
import wnderful.imgannotator.entity.Task;
import wnderful.imgannotator.entity.user.Requester;

import java.util.ArrayList;

public class EntityHelper {
    private UserDataServiceImpl userDataService = new UserDataServiceImpl();

    public Task dataToTask(TaskData taskData,Requester requester){

        return new Task(taskData.getTaskname(), requester, taskData.getTaskDescription(), taskData.getImgURL(),
                taskData.getReleasedTime(), taskData.getTaskTime(), taskData.getTaskTag(), taskData.getCredits(), taskData.getMaxWorkers());
    }

    public ArrayList<Task> dataToTasks(ArrayList<TaskData> taskData){
        ArrayList<Task> tasks = new ArrayList<>();
        String requestername = taskData.get(0).getRequestername();

        if (taskData != null) {
            for (int i = 0; i < taskData.size(); i++) {
                Requester requester = userDataService.findRequester(requestername);
                if (requester != null) {
                    Task task = dataToTask(taskData.get(i), requester);
                    tasks.add(task);
                }
            }
            return tasks;
        } else {
            return null;
        }
    }
}
