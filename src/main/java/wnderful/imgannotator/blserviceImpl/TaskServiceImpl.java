package wnderful.imgannotator.blserviceImpl;

import wnderful.imgannotator.blservice.TaskService;
import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.*;
import wnderful.imgannotator.publicData.response.taskResponse.*;
import wnderful.imgannotator.vo.taskVo.*;

public class TaskServiceImpl implements TaskService {

    @Override
    public ReleaseTaskRep releaseTask(String username, String taskname, String taskDescription, String[] images,int numberOfImages, int taskTime, String[] taskTag, int credits, int maxWorkers) {
        return new ReleaseTaskRep(ReleaseTaskRepCode.SUCCESS);
    }

    @Override
    public DisplayReleasedTaskRep displayReleasedTask(String username) {
        DisplayTaskVo vo = new DisplayTaskVo();
        return new DisplayReleasedTaskRep(DisplayReleasedTaskRepCode.SUCCESS, vo);
    }

    @Override
    public ModifyTaskRep modifyTask(String username, String taskname, String taskDescription, int remainTime, String[] taskTag, int maxWorkers) {
        return new ModifyTaskRep(ModifyTaskRepCode.SUCCESS);
    }

    @Override
    public DeleteTaskRep deleteTask(String username, String taskName) {
        return new DeleteTaskRep(DeleteTaskRepCode.SUCCESS);
    }

    @Override
    public DisplayReceiptTaskRep displayReceiptTask(String username) {
        DisplayTaskVo vo = new DisplayTaskVo();
        return new DisplayReceiptTaskRep(DisplayReceiptTaskRepCode.SUCCESS, vo);
    }

    @Override
    public ReceiptTaskRep receiptTask(String username, String taskName) {
        return new ReceiptTaskRep(ReceiptTaskRepCode.SUCCESS);
    }


    @Override
    public AbandonTaskRep abandonTask(String username, String taskName) {
        return new AbandonTaskRep(AbandonTaskRepCode.SUCCESS);
    }
}
