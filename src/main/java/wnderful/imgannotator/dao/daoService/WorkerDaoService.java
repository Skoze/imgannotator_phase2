package wnderful.imgannotator.dao.daoService;

import com.alibaba.fastjson.JSON;
import wnderful.imgannotator.dao.data.UserData;
import wnderful.imgannotator.util.FileHelper;

import java.util.ArrayList;

public class WorkerDaoService {
    private FileHelper fileHelper = new FileHelper();

    public ArrayList selectAll(){
        return null;
    }

    public UserData findWorker(String workername) {
        if(fileHelper.dataExist("user/worker/"+workername)){
            String content = fileHelper.read("user/worker/"+workername+ ".txt");
            UserData userData = JSON.parseObject(content,UserData.class);
            return userData;
        }else {
            return null;
        }
    }

    public boolean addWorker(UserData userData) {
        String content = JSON.toJSONString(userData);
        return fileHelper.write("user/worker/"+userData.getUsername(),content);
    }

    public boolean setWorker(UserData userData) {
        String content = JSON.toJSONString(userData);
        return fileHelper.write("user/worker/"+userData.getUsername(),content);
    }

    public boolean deleteWorker(String workername) {
        return false;
    }

}
