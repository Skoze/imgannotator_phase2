package wnderful.imgannotator.dao.daoService;

import com.alibaba.fastjson.JSON;
import wnderful.imgannotator.dao.data.UserData;
import wnderful.imgannotator.util.FileHelper;

import java.util.ArrayList;

public class RequesterDaoService {
    private FileHelper fileHelper = new FileHelper();

    public ArrayList selectAll(){
        return null;
    }

    public UserData findRequester(String requestername){
        if(fileHelper.dataExist("user/requester/"+requestername)){
            String content = fileHelper.read("user/requester/"+requestername+ ".txt");
            UserData userData = JSON.parseObject(content,UserData.class);
            return userData;
        }else {
            return null;
        }
    }

    public boolean setRequester(UserData userData){
        String content = JSON.toJSONString(userData);
        return fileHelper.write("user/requester/"+userData.getUsername(),content);
    }

    public boolean addRequester(UserData userData){
        String content = JSON.toJSONString(userData);
        return fileHelper.write("user/requester/"+userData.getUsername(),content);
    }

    public boolean deleteRequester(String requestername){
        return true;
    }
    public boolean deleteAll(){
        return fileHelper.deleteAll("data/user/requester");
    }

}
