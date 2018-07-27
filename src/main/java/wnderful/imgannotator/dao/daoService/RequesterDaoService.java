package wnderful.imgannotator.dao.daoService;

import wnderful.imgannotator.dao.data.UserData;

import java.util.ArrayList;

public class RequesterDaoService {
    public ArrayList selectAll(){
        return null;
    }

    public UserData findUser(String requestername){
        return new UserData();
    }

    public boolean setRequester(UserData userData){
        return true;
    }

    public boolean addRequester(UserData userData){
        return true;
    }

    public boolean deleteRequester(String requestername){
        return true;
    }
}
