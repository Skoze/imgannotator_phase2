package wnderful.imgannotator.blserviceImpl;

import wnderful.imgannotator.blservice.BaseService;
import wnderful.imgannotator.dataServiceImpl.UserDataServiceImpl;
import wnderful.imgannotator.dao.data.UserData;
import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.DisplayAllTaskRepCode;
import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.DisplayDetailRepCode;
import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.LoginRepCode;
import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.SignUpRepCode;
import wnderful.imgannotator.publicData.response.baseResponse.DisplayAllTaskRep;
import wnderful.imgannotator.publicData.response.baseResponse.DisplayDetailRep;
import wnderful.imgannotator.publicData.response.baseResponse.LoginRep;
import wnderful.imgannotator.publicData.response.baseResponse.SignUpRep;
import wnderful.imgannotator.vo.baseVo.DisplayDetailVo;
import wnderful.imgannotator.vo.baseVo.LoginVo;
import wnderful.imgannotator.util.jwt.*;
import wnderful.imgannotator.vo.taskVo.DisplayTaskVo;

public class BaseServiceImpl implements BaseService {
    UserDataServiceImpl userDataService = new UserDataServiceImpl();
    JwtHelper jwtHelper = new JwtHelper();

    @Override
    public LoginRep login(String username, String password) {
        UserData userData = userDataService.findUser(username);

        //判断用户是否存在
        if(userData == null){
            return new LoginRep(LoginRepCode.NOTEXIST);
        }else{
            if(userData.getPassword().equals(password)){
                LoginVo vo = new LoginVo();
                try{
                    vo.setToken(jwtHelper.createToken(username));
                    return new LoginRep(LoginRepCode.SUCCESS, vo);
                }catch (Exception ex){
                    ex.printStackTrace();
                    return new LoginRep(LoginRepCode.UNKNOW);
                }
            }else {
                return new LoginRep(LoginRepCode.FAIL);
            }
        }
    }

    @Override
    public SignUpRep signUp(String username, String password, String email, String role) {

        //判断用户名是否重复
        if(userDataService.findUser(username)!=null){
            return new SignUpRep(SignUpRepCode.NAMEREPEAT);
        }else{
            UserData userData = new UserData(username,password,email,role);
            if(userDataService.saveUser(userData)){
                return new SignUpRep(SignUpRepCode.SUCCESS);
            }else{
                return new SignUpRep(SignUpRepCode.FAIL);
            }
        }
    }

    @Override
    public DisplayDetailRep displayDetail(String taskName) {
        DisplayDetailVo vo = new DisplayDetailVo();
        return new DisplayDetailRep(DisplayDetailRepCode.SUCCESS, vo);
    }

    @Override
    public DisplayAllTaskRep displayAllTask() {
        DisplayTaskVo vo = new DisplayTaskVo();
        return new DisplayAllTaskRep(DisplayAllTaskRepCode.SUCCESS, vo);
    }
}
