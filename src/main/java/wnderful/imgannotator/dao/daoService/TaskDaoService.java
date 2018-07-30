package wnderful.imgannotator.dao.daoService;

import com.alibaba.fastjson.JSON;
import wnderful.imgannotator.dao.data.TaskData;
import wnderful.imgannotator.util.FileHelper;

import java.util.ArrayList;

public class TaskDaoService {
    private FileHelper fileHelper = new FileHelper();

    public ArrayList<TaskData> selectAll() {
        ArrayList<String> list = fileHelper.readList("task/");
        ArrayList<TaskData> taskDataArrayList = new ArrayList<>();
        if (list != null) {
            for (String content : list) {
                TaskData taskData = JSON.parseObject(content, TaskData.class);
                taskDataArrayList.add(taskData);
            }
            return taskDataArrayList;
        } else {
            return null;
        }
    }

    public ArrayList<TaskData> selectByRequester(String requestername) {
        ArrayList<TaskData> taskDataArrayList = selectAll();
        if(taskDataArrayList!=null){
            ArrayList<TaskData> requesterTasks = new ArrayList<>();
            for(TaskData taskData:taskDataArrayList){
                if(taskData.getRequestername().equals(requestername)){
                    requesterTasks.add(taskData);
                }
            }
            return requesterTasks;
        }
        return null;
    }

    public TaskData findTask(String taskname) {
        if(fileHelper.dataExist("task/"+taskname)){
            String content = fileHelper.read("task/"+taskname+ ".txt");
            TaskData taskData = JSON.parseObject(content,TaskData.class);
            return taskData;
        }else {
            return null;
        }
    }

    public boolean setTask(TaskData taskData) {
        String content = JSON.toJSONString(taskData);
        return fileHelper.write("task/"+taskData.getTaskname(),content);
    }

    public boolean addTask(TaskData taskData) {
        String content = JSON.toJSONString(taskData);
        return fileHelper.write("task/"+taskData.getTaskname(),content);
    }

    public boolean deleteTask(String taskname) {
        return true;
    }
}
