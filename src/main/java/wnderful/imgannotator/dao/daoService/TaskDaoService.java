package wnderful.imgannotator.dao.daoService;

import wnderful.imgannotator.dao.data.TaskData;
import wnderful.imgannotator.entity.Task;

import java.util.ArrayList;

public class TaskDaoService {
    public ArrayList<TaskData>selectAll(){
        return null;
    }

    public ArrayList<TaskData> selectByRequester(String Requestername){
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
