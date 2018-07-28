package wnderful.imgannotator.blserviceImpl;

import wnderful.imgannotator.blservice.TaskService;
import wnderful.imgannotator.dataServiceImpl.ImgDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.TaskDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.UserDataServiceImpl;
import wnderful.imgannotator.entity.Task;
import wnderful.imgannotator.entity.user.Requester;
import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.*;
import wnderful.imgannotator.publicData.response.taskResponse.*;
import wnderful.imgannotator.util.CreateVoHelper;
import wnderful.imgannotator.vo.taskVo.*;

import java.util.ArrayList;

public class TaskServiceImpl implements TaskService {

    private UserDataServiceImpl userDataService = new UserDataServiceImpl();
    private TaskDataServiceImpl taskDataService = new TaskDataServiceImpl();
    private ImgDataServiceImpl imgDataService = new ImgDataServiceImpl();
    private CreateVoHelper helper = new CreateVoHelper();

    @Override
    public ReleaseTaskRep releaseTask(String username, String taskname, String taskDescription, int numberOfImages, int taskTime, String[] taskTag, int credits, int maxWorkers) {
        if (userDataService.requesterExist(username)) {
            Requester requester = userDataService.findRequester(username);
            if (taskDataService.exist(taskname)) {
                return new ReleaseTaskRep(ReleaseTaskRepCode.REPEAT);
            } else {
                String URL = imgDataService.findFirstImgURL(taskname);
                if (URL .equals("") || URL == null) {
                    return new ReleaseTaskRep(ReleaseTaskRepCode.NOIMG);
                } else {
                    Task task = new Task(taskname, requester, taskDescription, URL, taskTime, taskTag, credits, maxWorkers);
                    boolean Success = taskDataService.uploadTask(task);
                    if (Success) {
                        return new ReleaseTaskRep(ReleaseTaskRepCode.SUCCESS);
                    }
                }
            }
        } else {
            return new ReleaseTaskRep(ReleaseTaskRepCode.NOTFOUND);
        }
        return new ReleaseTaskRep(ReleaseTaskRepCode.FAIL);
    }

    @Override
    public DisplayReleasedTaskRep displayReleasedTask(String username) {
        if(userDataService.requesterExist(username)){
            ArrayList<Task> tasks = taskDataService.findReleaseTasks(username);
            if(tasks != null){
                DisplayTaskVo vo = helper.createDisplayTaskVo(tasks);
                if(vo != null){
                    return new DisplayReleasedTaskRep(DisplayReleasedTaskRepCode.SUCCESS,vo);
                }
            }else{
                return new DisplayReleasedTaskRep(DisplayReleasedTaskRepCode.NOTASK);
            }
        }else{
            return new DisplayReleasedTaskRep(DisplayReleasedTaskRepCode.NOTFOUND);
        }
        return new DisplayReleasedTaskRep(DisplayReleasedTaskRepCode.FAIL);
    }

    @Override
    public DisplayReceiptTaskRep displayReceiptTask(String username) {
        if(userDataService.workerExist(username)){
            ArrayList<Task> tasks = taskDataService.findReceiptTasks(username);
            if(tasks != null){
                DisplayTaskVo vo = helper.createDisplayTaskVo(tasks);
                if(vo != null){
                    return new DisplayReceiptTaskRep(DisplayReceiptTaskRepCode.SUCCESS,vo);
                }
            }else{
                return new DisplayReceiptTaskRep(DisplayReceiptTaskRepCode.NOTASK);
            }
        }else{
            return new DisplayReceiptTaskRep(DisplayReceiptTaskRepCode.NOTFOUND);
        }
        return new DisplayReceiptTaskRep(DisplayReceiptTaskRepCode.FAIL);
    }

    @Override
    public ModifyTaskRep modifyTask(String username, String taskname, String taskDescription, int remainTime, String[] taskTag, int maxWorkers) {
        if(userDataService.requesterExist(username)){
            Task task = taskDataService.findTask(taskname);
            if(task != null){
                task.setTaskDescription(taskDescription);
                task.setTaskTime(remainTime);
                task.setTaskTag(taskTag);
                task.setMaxWorkers(maxWorkers);
                Boolean success = taskDataService.setTaskMessage(task);
                if(success){
                    return new ModifyTaskRep(ModifyTaskRepCode.SUCCESS);
                }
            }else{
                return new ModifyTaskRep(ModifyTaskRepCode.NOTASK);
            }
        }else{
            return  new ModifyTaskRep(ModifyTaskRepCode.NOTFOUND);
        }
        return new ModifyTaskRep(ModifyTaskRepCode.FAIL);
    }

    @Override
    public DeleteTaskRep deleteTask(String username, String taskname) {
        if(userDataService.requesterExist(username)){
            Task task = taskDataService.findTask(taskname);
            if(task != null){
                Boolean success = taskDataService.endTask(taskname);
                if(success){
                    return new DeleteTaskRep(DeleteTaskRepCode.SUCCESS);
                }
            }else{
                return new DeleteTaskRep(DeleteTaskRepCode.NOTASK);
            }
        }else {
            return new DeleteTaskRep(DeleteTaskRepCode.NOTFOUND);
        }
        return new DeleteTaskRep(DeleteTaskRepCode.FAIL);
    }

    @Override
    public ReceiptTaskRep receiptTask(String username, String taskname) {
        if(userDataService.workerExist(username)){
            Task task = taskDataService.findTask(taskname);
            if(task != null){
                if(task.getMaxWorkers() <= task.getRecentWorkers()){
                    return new ReceiptTaskRep(ReceiptTaskRepCode.FULL);
                }else{
                    if(userDataService.addWorkerTask(username,task)){
                        return new ReceiptTaskRep(ReceiptTaskRepCode.SUCCESS);
                    }
                }
            }else{
                return new ReceiptTaskRep(ReceiptTaskRepCode.NOTASK);
            }
        }else {
            return new ReceiptTaskRep(ReceiptTaskRepCode.NOTFOUND);
        }

        return new ReceiptTaskRep(ReceiptTaskRepCode.FAIL);
    }


    @Override
    public AbandonTaskRep abandonTask(String username, String taskname) {
        if(userDataService.workerExist(username)){
            if(taskDataService.hasReceiptTask(taskname,username)){
                Task task = taskDataService.findTask(taskname);
                if(userDataService.abandonWorkerTask(username,task)){
                    return new AbandonTaskRep(AbandonTaskRepCode.SUCCESS);
                }
            }else{
                return new AbandonTaskRep(AbandonTaskRepCode.NOTASK);
            }
        }else{
            return new AbandonTaskRep(AbandonTaskRepCode.NOTFOUND);
        }
        return new AbandonTaskRep(AbandonTaskRepCode.FAIL);
    }
}
