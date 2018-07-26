package wnderful.imgannotator.blserviceImpl;

import wnderful.imgannotator.blservice.BaseService;
import wnderful.imgannotator.dataServiceImpl.UserDataServiceImpl;
import wnderful.imgannotator.entity.User;
import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.DisplayAllTaskRepCode;
import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.DisplayDetailRepCode;
import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.LoginRepCode;
import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.SignUpRepCode;
import wnderful.imgannotator.publicData.response.baseResponse.DisplayAllTaskRep;
import wnderful.imgannotator.publicData.response.baseResponse.DisplayDetailRep;
import wnderful.imgannotator.publicData.response.baseResponse.LoginRep;
import wnderful.imgannotator.publicData.response.baseResponse.SignUpRep;
import wnderful.imgannotator.vo.baseVo.DisplayAllTaskVo;
import wnderful.imgannotator.vo.baseVo.DisplayDetailVo;
import wnderful.imgannotator.vo.baseVo.LoginVo;
import wnderful.imgannotator.util.jwt.*;

public class BaseServiceImpl implements BaseService {
    UserDataServiceImpl userDataService = new UserDataServiceImpl();
    JwtHelper jwtHelper = new JwtHelper();

    @Override
    public LoginRep login(String username, String password) {
        User user= userDataService.findUser(username);

        //判断用户是否存在
        if(user == null){
            return new LoginRep(LoginRepCode.NOTEXIST);
        }else{
            if(user.getPassword().equals(password)){
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
            User user = new User(username,password,email,role);
            if(userDataService.saveUser(user)){
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
        DisplayAllTaskVo vo = new DisplayAllTaskVo();
        return new DisplayAllTaskRep(DisplayAllTaskRepCode.SUCCESS, vo);
    }
}
