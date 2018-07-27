package wnderful.imgannotator.dao.daoService;

import wnderful.imgannotator.dao.data.TaskData;

import java.util.ArrayList;

public class TaskDaoService {
    public ArrayList selectAll(){
        return null;
    }

    public ArrayList selectByRequester(String Requestername){
        return null;
    }

    public TaskData findTask(String taskname){
        return new TaskData();
    }

    public boolean setTask(TaskData taskData){
        return true;
    }

    public boolean addTask(TaskData taskData){
        return true;
    }

    public boolean deleteTask(String taskname){
        return true;
    }
}
