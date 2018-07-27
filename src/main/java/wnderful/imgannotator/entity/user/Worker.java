package wnderful.imgannotator.entity.user;

import wnderful.imgannotator.entity.Task;

import java.util.ArrayList;

public class Worker extends User {
    private ArrayList<Task> receiptTasks;
    private int points;
    private int completedTasks;
    private int completedImages;

    public Task getTask(String taskname){
        return null;
    }
}
