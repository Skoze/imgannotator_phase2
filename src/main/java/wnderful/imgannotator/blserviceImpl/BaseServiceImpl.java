package wnderful.imgannotator.blserviceImpl;

import wnderful.imgannotator.blservice.BaseService;
import wnderful.imgannotator.dataServiceImpl.TaskDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.UserDataServiceImpl;
import wnderful.imgannotator.entity.Task;
import wnderful.imgannotator.entity.user.User;
import wnderful.imgannotator.entity.user.Worker;
import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.DisplayAllTaskRepCode;
import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.DisplayDetailRepCode;
import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.LoginRepCode;
import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.SignUpRepCode;
import wnderful.imgannotator.publicData.response.baseResponse.DisplayAllTaskRep;
import wnderful.imgannotator.publicData.response.baseResponse.DisplayDetailRep;
import wnderful.imgannotator.publicData.response.baseResponse.LoginRep;
import wnderful.imgannotator.publicData.response.baseResponse.SignUpRep;
import wnderful.imgannotator.util.CreateVoHelper;
import wnderful.imgannotator.vo.baseVo.DisplayDetailVo;
import wnderful.imgannotator.vo.baseVo.LoginVo;
import wnderful.imgannotator.util.jwt.*;
import wnderful.imgannotator.vo.baseVo.WorkerVo;
import wnderful.imgannotator.vo.taskVo.DisplayTaskVo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class BaseServiceImpl implements BaseService {
    private UserDataServiceImpl userDataService = new UserDataServiceImpl();
    private TaskDataServiceImpl taskDataService = new TaskDataServiceImpl();
    private JwtHelper jwtHelper = new JwtHelper();
    private CreateVoHelper createVoHelper = new CreateVoHelper();

    //登陆
    @Override
    public LoginRep login(String username, String password) throws UnsupportedEncodingException {
        if (!username.equals("")) {
            if (userDataService.userExist(username)) {
                if (!password.equals("")) {
                    User user = userDataService.findUser(username);
                    if (user.getPassword().equals(password)) {
                        String token = jwtHelper.createToken(username);
                        LoginVo vo = new LoginVo(token, user.getRole());
                        return new LoginRep(LoginRepCode.SUCCESS, vo);
                    } else {
                        return new LoginRep(LoginRepCode.WRONGPASSWORD);
                    }
                } else {
                    return new LoginRep(LoginRepCode.EMPTYPASSWORD);
                }
            } else {
                return new LoginRep(LoginRepCode.NOTEXIST);
            }
        } else {
            return new LoginRep(LoginRepCode.EMPTYNAME);
        }
    }

    //注册
    @Override
    public SignUpRep signUp(String username, String password, String email, String role) {
        if (!userDataService.userExist(username)) {
            if (!username.equals("")) {
                if (!password.equals("")) {
                    if (!email.equals("")) {
                        User user = new User(username, password, email, role);
                        if (userDataService.newUser(user)) {
                            return new SignUpRep(SignUpRepCode.SUCCESS);
                        } else {
                            return new SignUpRep(SignUpRepCode.FAIL);
                        }
                    }
                    return new SignUpRep(SignUpRepCode.EMPTYEMAIL);
                } else {
                    return new SignUpRep(SignUpRepCode.EMPTYPASSWORD);
                }
            } else {
                return new SignUpRep(SignUpRepCode.EMPTYNAME);
            }
        } else {
            return new SignUpRep(SignUpRepCode.NAMEREPEAT);
        }
    }

    @Override
    public DisplayDetailRep displayDetail(String taskName) {
        if (taskDataService.exist(taskName)) {
            Task task = taskDataService.findTask(taskName);
            if (task != null) {
                ArrayList<Worker> workers = userDataService.findTaskWorker(taskName);
                if (workers != null) {
                    WorkerVo[] workerVos = createVoHelper.createWorkerVo(workers, taskName);
                    DisplayDetailVo vo = createVoHelper.createDisplayDetailVo(task, workerVos);
                    return new DisplayDetailRep(DisplayDetailRepCode.SUCCESS, vo);
                } else {
                    return new DisplayDetailRep(DisplayDetailRepCode.FAIL);
                }
            } else {
                return new DisplayDetailRep(DisplayDetailRepCode.NOTASK);
            }
        } else {
            return new DisplayDetailRep(DisplayDetailRepCode.NOTASK);
        }
    }

    @Override
    public DisplayAllTaskRep displayAllTask() {
        ArrayList<Task> tasks = taskDataService.findAllTask();
        if (tasks != null&&tasks.size()>0) {
            DisplayTaskVo vo = createVoHelper.createDisplayTaskVo(tasks);
            return new DisplayAllTaskRep(DisplayAllTaskRepCode.SUCCESS, vo);
        } else {
            return new DisplayAllTaskRep(DisplayAllTaskRepCode.SUCCESS);
        }
    }
}
