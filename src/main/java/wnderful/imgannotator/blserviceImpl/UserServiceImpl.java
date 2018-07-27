package wnderful.imgannotator.blserviceImpl;

import wnderful.imgannotator.blservice.UserService;
import wnderful.imgannotator.publicData.reponseCode.userResponseCode.GetUserMassageRepCode;
import wnderful.imgannotator.publicData.reponseCode.userResponseCode.UpdateUserMessageRepCode;
import wnderful.imgannotator.publicData.response.userResponse.GetUserMassageRep;
import wnderful.imgannotator.publicData.response.userResponse.UpdateUserMessageRep;
import wnderful.imgannotator.vo.userVo.UserMessageVo;
import wnderful.imgannotator.vo.userVo.WorkerMessageVo;

public class UserServiceImpl implements UserService {

    @Override
    public GetUserMassageRep getUserMessage(String username,String role) {
        WorkerMessageVo vo = new WorkerMessageVo();
        return new GetUserMassageRep(GetUserMassageRepCode.SUCCESS,vo);
    }

    @Override
    public UpdateUserMessageRep updateUserMessage(String username, String newUsername, String newEmail, String oldPassword, String newPassword){
        return new UpdateUserMessageRep(UpdateUserMessageRepCode.SUCCESS);
    }
}
