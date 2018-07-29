package wnderful.imgannotator.blserviceImpl;

import wnderful.imgannotator.blservice.UserService;
import wnderful.imgannotator.dataServiceImpl.UserDataServiceImpl;
import wnderful.imgannotator.entity.user.Requester;
import wnderful.imgannotator.entity.user.User;
import wnderful.imgannotator.entity.user.Worker;
import wnderful.imgannotator.publicData.reponseCode.userResponseCode.GetUserMassageRepCode;
import wnderful.imgannotator.publicData.reponseCode.userResponseCode.UpdateUserMessageRepCode;
import wnderful.imgannotator.publicData.response.userResponse.GetUserMassageRep;
import wnderful.imgannotator.publicData.response.userResponse.UpdateUserMessageRep;
import wnderful.imgannotator.vo.userVo.RequesterMessageVo;
import wnderful.imgannotator.vo.userVo.UserMessageVo;
import wnderful.imgannotator.vo.userVo.WorkerMessageVo;

public class UserServiceImpl implements UserService {
    UserDataServiceImpl userDataService = new UserDataServiceImpl();


    @Override
    public GetUserMassageRep getUserMessage(String username, String role) {
        if (role == "worker") {
            Worker worker = userDataService.findWorker(username);
            if (worker == null) {
                return new GetUserMassageRep(GetUserMassageRepCode.NOTFOUND);
            } else {
                WorkerMessageVo vo = new WorkerMessageVo(worker.getUsername(), worker.getEmail(), worker.getPoints(),
                        worker.getCompletedTasks(), worker.getCompletedImages());
                return new GetUserMassageRep(GetUserMassageRepCode.SUCCESS, vo);
            }
        } else if (role == "requester") {
            Requester requester = userDataService.findRequester(username);
            if (requester == null) {
                return new GetUserMassageRep(GetUserMassageRepCode.NOTFOUND);
            } else {
                RequesterMessageVo vo = new RequesterMessageVo(requester.getUsername(), requester.getEmail(),
                        requester.getPoints(), requester.getReleasedTasks());
                return new GetUserMassageRep(GetUserMassageRepCode.SUCCESS, vo);
            }
        }
        return new GetUserMassageRep(GetUserMassageRepCode.FAIL);
    }

    @Override
    public UpdateUserMessageRep updateUserMessage(String username, String newEmail, String oldPassword, String newPassword,String role) {

        if (!userDataService.userExist(username)) {
            return new UpdateUserMessageRep(UpdateUserMessageRepCode.NOTFOUND);
        } else {
            User user = userDataService.findUser("username");
            user.setEmail(newEmail);

            if (oldPassword.equals(newPassword)) {
                return new UpdateUserMessageRep(UpdateUserMessageRepCode.REPEAT);
            } else {
                user.setPassword(newPassword);

                boolean success = false;
                if (role .equals("worker") ) {
                    success = userDataService.setWorkerMessage(user);
                } else if (role.equals("requester")) {
                    success = userDataService.setRequesterMessage(user);
                }
                if(success){
                    return new UpdateUserMessageRep(UpdateUserMessageRepCode.SUCCESS);
                }
            }

        }
        return new UpdateUserMessageRep(UpdateUserMessageRepCode.FAIL);
    }
}
