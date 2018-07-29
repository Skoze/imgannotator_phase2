package wnderful.imgannotator.dao.daoService;

import wnderful.imgannotator.dao.data.UserData;
import wnderful.imgannotator.dao.data.WorkData;
import wnderful.imgannotator.entity.user.User;

import java.util.ArrayList;

public class WorkDaoService {
    public ArrayList selectAll(){
        return null;
    }

    public ArrayList<String> selectWorkerByImg(String imgname){
        return null;
    }

    public ArrayList<WorkData> selectbyWorker(String workername){
        return null;
    }

    public ArrayList<String> selectImgByWorker(String workername){
        return null;
    }

    public WorkData findWork(String workname){
        return new WorkData();
    }

    public boolean setWork(WorkData workData){
        return true;
    }
    public boolean addWork(WorkData workData){
        return true;
    }

    public boolean deleteWork(String  workname){
        return true;
    }
}
