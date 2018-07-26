package wnderful.imgannotator.dataServiceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import wnderful.imgannotator.dataService.UserDataService;
import wnderful.imgannotator.entity.User;
import wnderful.imgannotator.util.FileHelper;

import java.util.HashMap;
import java.util.Map;

public class UserDataServiceImpl implements UserDataService {
    final FileHelper fileHelper = new FileHelper();

    @Override
    public boolean saveUser(User user){
        String jsonStr = JSON.toJSONString(user);
        Boolean result = fileHelper.write("user/"+user.getUsername(),jsonStr);
        return result;
    }

    @Override
    public User findUser(String username){
        String jsonStr = fileHelper.read("user/"+username);
        if(jsonStr.equals("")){
            return null;
        }else{
            User user = JSON.parseObject(jsonStr,User.class);
            return user;
        }
    }

    @Override
    public Map getAllUser(){
        Map<String,User> userMap = new HashMap<>();
        return userMap;
    }
}