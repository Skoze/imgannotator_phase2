package wnderful.imgannotator.blserviceImpl;

import wnderful.imgannotator.blservice.TaskService;
import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.*;
import wnderful.imgannotator.publicData.response.taskResponse.*;
import wnderful.imgannotator.vo.taskVo.*;

public class TaskServiceImpl implements TaskService {

    @Override
    public ReleaseTaskRep releaseTask(String username, String taskname, String taskDescription, String images,int numberOfImages, int taskTime, String[] taskTag, int credits, int maxWorkers) {
        ReleaseTaskVo vo = new ReleaseTaskVo();
        return new ReleaseTaskRep(ReleaseTaskRepCode.SUCCESS, vo);
    }

    @Override
    public DisplayReleasedTaskRep displayReleasedTask(String username) {
        DisplayReleasedTaskVo vo = new DisplayReleasedTaskVo();
        return new DisplayReleasedTaskRep(DisplayReleasedTaskRepCode.SUCCESS, vo);
    }

    @Override
    public ModifyTaskRep modifyTask(String username, String taskname, String taskDescription, int remainTime, String[] taskTag, int maxWorkers) {
        ModifyTaskVo vo = new ModifyTaskVo();
        return new ModifyTaskRep(ModifyTaskRepCode.SUCCESS, vo);
    }

    @Override
    public DeleteTaskRep deleteTask(String username, String taskName) {
        DeleteTaskVo vo = new DeleteTaskVo();
        return new DeleteTaskRep(DeleteTaskRepCode.SUCCESS, vo);
    }

    @Override
    public DisplayReceiptTaskRep displayReceiptTask(String username) {
        DisplayReceiptTaskVo vo = new DisplayReceiptTaskVo();
        return new DisplayReceiptTaskRep(DisplayReceiptTaskRepCode.SUCCESS, vo);
    }

    @Override
    public ReceiptTaskRep receiptTask(String username, String taskName) {
        ReceiptTaskVo vo = new ReceiptTaskVo();
        return new ReceiptTaskRep(ReceiptTaskRepCode.SUCCESS, vo);
    }


    @Override
    public AbandonTaskRep abandonTask(String username, String taskName) {
        AbandonTaskVo vo = new AbandonTaskVo();
        return new AbandonTaskRep(AbandonTaskRepCode.SUCCESS, vo);
    }
}
