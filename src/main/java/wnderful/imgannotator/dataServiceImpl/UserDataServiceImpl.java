package wnderful.imgannotator.dataServiceImpl;

import com.alibaba.fastjson.JSON;
import wnderful.imgannotator.dao.data.UserData;
import wnderful.imgannotator.dataService.UserDataService;
import wnderful.imgannotator.util.FileHelper;

import java.util.HashMap;
import java.util.Map;

public class UserDataServiceImpl implements UserDataService {
    final FileHelper fileHelper = new FileHelper();

    @Override
    public boolean saveUser(UserData userData){
        String jsonStr = JSON.toJSONString(userData);
        Boolean result = fileHelper.write("userData/"+ userData.getUsername(),jsonStr);
        return result;
    }

    @Override
    public UserData findUser(String username){
        String jsonStr = fileHelper.read("user/"+username);
        if(jsonStr.equals("")){
            return null;
        }else{
            UserData userData = JSON.parseObject(jsonStr,UserData.class);
            return userData;
        }
    }

    @Override
    public Map getAllUser(){
        Map<String,UserData> userMap = new HashMap<>();
        return userMap;
    }
}