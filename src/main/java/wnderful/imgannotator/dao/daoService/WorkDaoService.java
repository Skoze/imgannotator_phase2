package wnderful.imgannotator.dao.daoService;

import wnderful.imgannotator.dao.data.WorkData;

import java.util.ArrayList;

public class WorkDaoService {
    public ArrayList selectAll(){
        return null;
    }

    public ArrayList selectbyImg(String imgname){
        return null;
    }

    public ArrayList selectbyWorker(String workername){
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
