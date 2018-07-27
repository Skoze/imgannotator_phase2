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
        return new LoginRep(LoginRepCode.NOTEXIST);
    }

    @Override
    public SignUpRep signUp(String username, String password, String email, String role) {
        return new SignUpRep(SignUpRepCode.SUCCESS);
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
