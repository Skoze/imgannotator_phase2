package wnderful.imgannotator.dao.daoService;

import com.alibaba.fastjson.JSON;
import wnderful.imgannotator.dao.data.ProcessData;
import wnderful.imgannotator.util.FileHelper;

import java.util.ArrayList;

public class ProcessDaoService {
    private FileHelper fileHelper = new FileHelper();

    public ArrayList selectAll(){
        ArrayList<String> list = fileHelper.readList("process/");
        ArrayList<ProcessData> processDataArrayList = new ArrayList<>();
        if (list != null) {
            for (String content : list) {
               ProcessData taskData = JSON.parseObject(content, ProcessData.class);
                processDataArrayList.add(taskData);
            }
            return processDataArrayList;
        } else {
            return null;
        }
    }

    public ArrayList<ProcessData> selectByWorker(String workername){
        ArrayList<ProcessData> processDataArrayList = selectAll();
        if(processDataArrayList!=null){
            ArrayList<ProcessData> workerTasks = new ArrayList<>();
            for(ProcessData processData:processDataArrayList){
                if(processData.getWorkername().equals(workername)){
                    workerTasks.add(processData);
                }
            }
            return workerTasks;
        }
        return null;
    }

    public ArrayList<ProcessData> selectByTask(String taskname){
        ArrayList<ProcessData> processDataArrayList = selectAll();
        if(processDataArrayList!=null){
            ArrayList<ProcessData> taskWorker = new ArrayList<>();
            for(ProcessData processData:processDataArrayList){
                if(processData.getTaskname().equals(taskname)){
                    taskWorker.add(processData);
                }
            }
            return taskWorker;
        }
        return null;
    }


    public ProcessData findProcess(String processname){
        if(fileHelper.dataExist("process/"+processname)){
            String content = fileHelper.read("process/"+processname+ ".txt");
            ProcessData processData = JSON.parseObject(content,ProcessData.class);
            return processData;
        }else {
            return null;
        }
    }

    public boolean setProcess(ProcessData processData) {
        String content = JSON.toJSONString(processData);
        return fileHelper.write("process/"+processData.getProcessname(),content);
    }

    public boolean addProcess(ProcessData processData) {
        String content = JSON.toJSONString(processData);
        return fileHelper.write("process/"+processData.getProcessname(),content);
    }

    public boolean deleteProcess(String processname) {
        if(fileHelper.dataExist("process/"+processname)){
            return fileHelper.dataExist("process/"+processname);
        }
        return false;
    }

    public boolean deleteAll(){
        return fileHelper.deleteAll("data/process");
    }
}
