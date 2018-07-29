package wnderful.imgannotator.dao.daoService;

import wnderful.imgannotator.dao.data.ProcessData;

import java.util.ArrayList;

public class ProcessDaoService {
    public ArrayList selectAll(){
        return null;
    }

    public ArrayList<ProcessData> selectByWorker(String workername){
        return null;
    }

    public ArrayList<ProcessData> selectByTask(String taskname){
        return null;
    }

    public ProcessData findProcess(String prcessname){
        return new ProcessData();
    }

    public boolean setProcess(ProcessData processData) {
        return true;
    }

    public boolean addProcess(ProcessData processData) {
        return true;
    }

    public boolean deleteProcess(String processname) {
        return true;
    }
}
