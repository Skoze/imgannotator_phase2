package wnderful.imgannotator.dao.daoService;

import wnderful.imgannotator.dao.data.UserData;

import java.util.ArrayList;

public class WorkerDaoService {
    public ArrayList selectAll(){
        return null;
    }

    public UserData findWorker(String workername) {
        return new UserData();
    }

    public boolean addWorker(UserData userData) {
        return true;
    }

    public boolean setWorker(UserData userData) {
        return true;
    }

    public boolean deleteWorker(String workername) {
        return false;
    }

}
