package wnderful.imgannotator.dataService;

import wnderful.imgannotator.entity.Task;
import wnderful.imgannotator.entity.user.Worker;

import java.util.ArrayList;

public interface TaskDataService {
    Task findTask(String taskname);

    int findProcess(String taskname,String workername);

    int findTaskProcess(String taskname);

    boolean exist(String taskname);

    boolean uploadTask(Task task);

    boolean setTaskMessage(Task task);

    boolean endTask(String taskname);

    boolean hasReceiptTask(String taskname,String workername);

    boolean isEnd(String taskname);

    boolean isComplete(String taskname,String workername);

    boolean isRelease(String taskname,String requestername);

    ArrayList<Task> findReleaseTasks(String requestername);

    ArrayList<Task> findReceiptTasks(String workername);

    ArrayList<Task> findAllTask();

    ArrayList<Worker> findTaskWorker(String taskName);
}
