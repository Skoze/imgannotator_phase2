package wnderful.imgannotator.blserviceImpl;

import wnderful.imgannotator.blservice.UserService;
import wnderful.imgannotator.dataServiceImpl.UserDataServiceImpl;
import wnderful.imgannotator.entity.user.Requester;
import wnderful.imgannotator.entity.user.User;
import wnderful.imgannotator.entity.user.Worker;
import wnderful.imgannotator.publicData.reponseCode.userResponseCode.AddPointsRepCode;
import wnderful.imgannotator.publicData.reponseCode.userResponseCode.GetUserMassageRepCode;
import wnderful.imgannotator.publicData.reponseCode.userResponseCode.LostPointsRepCode;
import wnderful.imgannotator.publicData.reponseCode.userResponseCode.UpdateUserMessageRepCode;
import wnderful.imgannotator.publicData.response.userResponse.AddPointsRep;
import wnderful.imgannotator.publicData.response.userResponse.GetUserMassageRep;
import wnderful.imgannotator.publicData.response.userResponse.LostPointsRep;
import wnderful.imgannotator.publicData.response.userResponse.UpdateUserMessageRep;
import wnderful.imgannotator.vo.userVo.RequesterMessageVo;
import wnderful.imgannotator.vo.userVo.WorkerMessageVo;

public class UserServiceImpl implements UserService {
    private UserDataServiceImpl userDataService = new UserDataServiceImpl();

    @Override
    public GetUserMassageRep getUserMessage(String username, String role) {
        switch (role) {
            case "requester":
                Requester requester = userDataService.findRequester(username);
                if (requester != null) {
                    RequesterMessageVo vo = new RequesterMessageVo(requester.getUsername(), requester.getEmail(),
                            requester.getPoints(), requester.getReleasedTasks());
                    return new GetUserMassageRep(GetUserMassageRepCode.SUCCESS, vo);
                }else {
                    return new GetUserMassageRep(GetUserMassageRepCode.FAIL);
                }
            case "worker":
                Worker worker = userDataService.findWorker(username);
                if (worker != null) {
                    WorkerMessageVo vo = new WorkerMessageVo(worker.getUsername(), worker.getEmail(), worker.getPoints(),
                            worker.getCompletedTasks(), worker.getCompletedImages());
                    return new GetUserMassageRep(GetUserMassageRepCode.SUCCESS, vo);
                }else {
                    return new GetUserMassageRep(GetUserMassageRepCode.FAIL);
                }
            default:
                return new GetUserMassageRep(GetUserMassageRepCode.NOTFOUND);
        }
    }

    @Override
    public UpdateUserMessageRep updateUserMessage(String username, String newEmail, String oldPassword, String newPassword, String role) {

        if (userDataService.userExist(username)) {
            User user = userDataService.findUser(username);
            if (user != null) {
                if (user.getPassword().equals(oldPassword)) {
                    if((!newEmail.equals(""))||(!newPassword.equals(""))){
                        if(!newEmail.equals("")){
                            user.setEmail(newEmail);

                        }

                        if(!newPassword.equals("")){
                            if (!oldPassword.equals(newPassword)) {
                                user.setPassword(newPassword);
                            } else {
                                return new UpdateUserMessageRep(UpdateUserMessageRepCode.REPEAT);
                            }
                        }

                        switch (role) {
                            case "requester":
                                if (userDataService.setRequesterMessage(user)) {
                                    return new UpdateUserMessageRep(UpdateUserMessageRepCode.SUCCESS);
                                }
                            case "worker":
                                if (userDataService.setWorkerMessage(user)) {
                                    return new UpdateUserMessageRep(UpdateUserMessageRepCode.SUCCESS);
                                }
                            default:
                                return new UpdateUserMessageRep(UpdateUserMessageRepCode.FAIL);
                        }
                    }else {
                        return new UpdateUserMessageRep(UpdateUserMessageRepCode.WRONGDATA);
                    }
                } else {
                    return new UpdateUserMessageRep(UpdateUserMessageRepCode.WRONGPASSWORD);
                }
            } else {
                return new UpdateUserMessageRep(UpdateUserMessageRepCode.FAIL);
            }
        } else {
            return new UpdateUserMessageRep(UpdateUserMessageRepCode.NOTFOUND);
        }
    }

    @Override
    public AddPointsRep addPoints(String username, int points) {
        if (userDataService.userExist(username)) {
            if (points > 0) {
                if (userDataService.modifyPoints(points, username)) {
                    return new AddPointsRep(AddPointsRepCode.SUCCESS);
                } else {
                    return new AddPointsRep(AddPointsRepCode.FAIL);
                }
            } else {
                return new AddPointsRep(AddPointsRepCode.UNPROPER);
            }
        } else {
            return new AddPointsRep(AddPointsRepCode.NOTFOUND);
        }
    }

    @Override
    public LostPointsRep lostPoints(String username, int points) {
        if (userDataService.userExist(username)) {
            if (points > 0) {
                if (userDataService.modifyPoints(-points, username)) {
                    return new LostPointsRep(LostPointsRepCode.SUCCESS);
                } else {
                    return new LostPointsRep(LostPointsRepCode.FAIL);
                }
            } else {
                return new LostPointsRep(LostPointsRepCode.UNPROPER);
            }
        } else {
            return new LostPointsRep(LostPointsRepCode.NOTFOUND);
        }
    }
}
