package wnderful.imgannotator.dataServiceImpl;

import wnderful.imgannotator.dataService.TaskDataService;
import wnderful.imgannotator.entity.Img;
import wnderful.imgannotator.entity.Task;
import wnderful.imgannotator.entity.user.Requester;
import wnderful.imgannotator.entity.user.Worker;

import java.util.ArrayList;

public class TaskDataServiceImpl implements TaskDataService {
    @Override
    public Task findTask(String taskname) {
        ArrayList<Img> imgs = new ArrayList<Img>();
        Requester requester = new Requester();
        String[] tags = new String[1];
        return new Task(taskname,imgs ,requester,"","imgURL", 0,"",
                100, 10,tags,0,0,0);
    }

    @Override
    public int findProcess(String taskname, String workername) {
        return 0;
    }

    @Override
    public boolean exist(String taskname) {
        return true;
    }

    @Override
    public boolean uploadTask(Task task) {
        return true;
    }

    @Override
    public boolean setTaskMessage(Task task) {
        return true;
    }

    @Override
    public boolean endTask(String taskname) {
        return false;
    }

    @Override
    public boolean hasReceiptTask(String taskname, String workername) {
        return true;
    }

    @Override
    public boolean isEnd(String taskname) {
        return false;
    }

    @Override
    public boolean isComplete(String taskname, String Workername) {
        return false;
    }

    @Override
    public boolean isRelease(String taskanem, String requestername) {
        return true;
    }

    @Override
    public ArrayList<Task> findReleaseTasks(String requestername) {
        Task task = new Task("taskname",
                "imgURL",
                0,
                null,
                0,
                10);
        ArrayList<Task> tasks = new ArrayList<Task>();
        tasks.add(task);
        return tasks;
    }

    @Override
    public ArrayList<Task> findReceiptTasks(String workername) {
        Task task = new Task("taskname",
                "imgURL",
                1,
                null,
                10,
                10);
        ArrayList<Task> tasks = new ArrayList<Task>();
        tasks.add(task);
        return tasks;
    }

    @Override
    public ArrayList<Worker> findTaskWorker(String taskName) {
        ArrayList<Worker> workers = new ArrayList<Worker>();
        Worker worker = new Worker();
        workers.add(worker);
        return workers;
    }

    @Override
    public ArrayList<Task> findAllTask() {
        Task task = new Task("taskname",
                "imgURL",
                1,
                null,
                10,
                10);
        ArrayList<Task> tasks = new ArrayList<Task>();
        tasks.add(task);
        return tasks;
    }
}
