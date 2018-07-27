package wnderful.imgannotator.dataServiceImpl;

import wnderful.imgannotator.dataService.TaskDataService;
import wnderful.imgannotator.entity.Task;

import java.util.ArrayList;

public class TaskDataServiceImpl implements TaskDataService {
    @Override
    public Task findTask(String taskname) {
        return null;
    }

    @Override
    public boolean exist(String taskname) {
        return false;
    }

    @Override
    public boolean uploadTask(Task task) {
        return false;
    }

    @Override
    public boolean setTask(Task task) {
        return false;
    }

    @Override
    public boolean endTask(String taskname) {
        return false;
    }

    @Override
    public ArrayList<Task> findReleaseTasks(String requestername) {
        return null;
    }

    @Override
    public ArrayList<Task> findReceiptTasks(String workername) {
        return null;
    }

    @Override
    public ArrayList<Task> findAllTask() {
        return null;
    }
}
