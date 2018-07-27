package wnderful.imgannotator.dataService;

import wnderful.imgannotator.entity.Task;

import java.util.ArrayList;

public interface TaskDataService {
    Task findTask(String taskname);

    boolean exist(String taskname);

    boolean uploadTask(Task task);

    boolean setTask(Task task);

    boolean endTask(String taskname);

    ArrayList<Task> findReleaseTasks(String requestername);

    ArrayList<Task> findReceiptTasks(String workername);

    ArrayList<Task> findAllTask();
}
