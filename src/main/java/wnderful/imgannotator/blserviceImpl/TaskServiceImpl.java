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
    public ReleaseTaskRep releaseTask(String username, String taskname, String taskDescription, int taskTime, String[] taskTag, int credits, int maxWorkers) {
        if (userDataService.requesterExist(username)) {
            if(taskTime>0&&credits>=0&&maxWorkers>0){
                Requester requester = userDataService.findRequester(username);
                if (requester.getPoints() >= credits * maxWorkers) {
                    if (!taskDataService.exist(taskname)) {
                        String URL = imgDataService.findFirstImgURL(taskname);
                        if (URL != null && (!URL.equals(""))) {
                            Task task = new Task(taskname, requester, taskDescription, URL, taskTime, taskTag, credits, maxWorkers);
                            if (taskDataService.uploadTask(task)) {
                                if (userDataService.modifyPoints(-credits * maxWorkers, username)) {
                                    return new ReleaseTaskRep(ReleaseTaskRepCode.SUCCESS);
                                } else {
                                    return new ReleaseTaskRep(ReleaseTaskRepCode.ALREADYUPLOAD);
                                }
                            } else {
                                return new ReleaseTaskRep(ReleaseTaskRepCode.FAIL);
                            }
                        } else {
                            return new ReleaseTaskRep(ReleaseTaskRepCode.NOIMG);
                        }
                    } else {
                        return new ReleaseTaskRep(ReleaseTaskRepCode.REPEAT);
                    }
                } else {
                    return new ReleaseTaskRep(ReleaseTaskRepCode.NOPOINT);
                }
            }else {
                return new ReleaseTaskRep(ReleaseTaskRepCode.WRONGDATA);
            }
        } else {
            return new ReleaseTaskRep(ReleaseTaskRepCode.NOTFOUND);
        }
    }

    @Override
    public DisplayReleasedTaskRep displayReleasedTask(String username) {
        if (userDataService.requesterExist(username)) {
            ArrayList<Task> tasks = taskDataService.findReleaseTasks(username);
            if (tasks != null&&tasks.size()>0) {
                DisplayTaskVo vo = helper.createDisplayTaskVo(tasks);
                if (vo != null) {
                    return new DisplayReleasedTaskRep(DisplayReleasedTaskRepCode.SUCCESS, vo);
                } else {
                    return new DisplayReleasedTaskRep(DisplayReleasedTaskRepCode.FAIL);
                }
            } else {
                return new DisplayReleasedTaskRep(DisplayReleasedTaskRepCode.NOTASK);
            }
        } else {
            return new DisplayReleasedTaskRep(DisplayReleasedTaskRepCode.NOTFOUND);
        }
    }

    @Override
    public DisplayReceiptTaskRep displayReceiptTask(String username) {
        if (userDataService.workerExist(username)) {
            ArrayList<Task> tasks = taskDataService.findReceiptTasks(username);
            if (tasks != null) {
                DisplayTaskVo vo = helper.createDisplayTaskVo(tasks);
                if (vo != null) {
                    return new DisplayReceiptTaskRep(DisplayReceiptTaskRepCode.SUCCESS, vo);
                } else {
                    return new DisplayReceiptTaskRep(DisplayReceiptTaskRepCode.FAIL);
                }
            } else {
                return new DisplayReceiptTaskRep(DisplayReceiptTaskRepCode.NOTASK);
            }
        } else {
            return new DisplayReceiptTaskRep(DisplayReceiptTaskRepCode.NOTFOUND);
        }
    }

    @Override
    public ModifyTaskRep modifyTask(String username, String taskname, String taskDescription, int remainTime, String[] taskTag, int maxWorkers) {
        if (userDataService.requesterExist(username)) {
            Requester requester = userDataService.findRequester(username);
            if (taskDataService.exist(taskname)) {
                Task task = taskDataService.findTask(taskname);
                if(task.getRequester().getUsername().equals(username)){
                    task.setTaskDescription(taskDescription);
                    if(remainTime>=1){
                        task.setTaskTime(remainTime);
                        task.setTaskTag(taskTag);
                        if(maxWorkers == task.getMaxWorkers()){
                            if (taskDataService.setTaskMessage(task)) {
                                return new ModifyTaskRep(ModifyTaskRepCode.SUCCESS);
                            } else {
                                return new ModifyTaskRep(ModifyTaskRepCode.FAIL);
                            }
                        }else if(maxWorkers > task.getMaxWorkers()){
                            int needPoints = (maxWorkers-task.getMaxWorkers())*task.getCredits();
                            if(requester.getPoints()>=needPoints){
                                task.setMaxWorkers(maxWorkers);
                                if (taskDataService.setTaskMessage(task)) {
                                    if(userDataService.modifyPoints(-needPoints,username)){
                                        return new ModifyTaskRep(ModifyTaskRepCode.SUCCESS);
                                    }else {
                                        return new ModifyTaskRep(ModifyTaskRepCode.POINTSERROR);
                                    }
                                } else {
                                    return new ModifyTaskRep(ModifyTaskRepCode.FAIL);
                                }
                            }else {
                                return new ModifyTaskRep(ModifyTaskRepCode.NOPOINTS);
                            }
                        }else {
                            return new ModifyTaskRep(ModifyTaskRepCode.WRONGMAXWORKER);
                        }
                    }else {
                        return new ModifyTaskRep(ModifyTaskRepCode.WRONGTIME);
                    }
                }else {
                    return new ModifyTaskRep(ModifyTaskRepCode.NORIGHT);
                }
            } else {
                return new ModifyTaskRep(ModifyTaskRepCode.NOTASK);
            }
        } else {
            return new ModifyTaskRep(ModifyTaskRepCode.NOTFOUND);
        }
    }

    @Override
    public DeleteTaskRep deleteTask(String username, String taskname) {
        if (userDataService.requesterExist(username)) {
            Task task = taskDataService.findTask(taskname);
            if (task != null) {
                if (task.getRequester().getUsername().equals(username)) {
                    if(task.getTaskTime() > 0){
                        if (taskDataService.endTask(taskname)) {
                            int points = task.getCredits()*task.getMaxWorkers();
                            int restPoints = userDataService.settlePoints(taskname,points,task.getCredits());
                            if(userDataService.modifyPoints(restPoints,username)){
                                return new DeleteTaskRep(DeleteTaskRepCode.SUCCESS);
                            }else {
                                return  new DeleteTaskRep(DeleteTaskRepCode.POINTERROR);
                            }
                        } else {
                            return new DeleteTaskRep(DeleteTaskRepCode.FAIL);
                        }
                    }else {
                        return new DeleteTaskRep((DeleteTaskRepCode.HASEND));
                    }
                } else {
                    return new DeleteTaskRep(DeleteTaskRepCode.WRONGREQ);
                }
            } else {
                return new DeleteTaskRep(DeleteTaskRepCode.NOTASK);
            }
        } else {
            return new DeleteTaskRep(DeleteTaskRepCode.NOTFOUND);
        }
    }

    @Override
    public ReceiptTaskRep receiptTask(String username, String taskname) {
        if (userDataService.workerExist(username)) {
            Task task = taskDataService.findTask(taskname);
            if (task != null) {
                if (!taskDataService.hasReceiptTask(taskname, username)) {
                    if(task.getTaskTime()>0){
                        if (task.getMaxWorkers() > task.getRecentWorkers()) {
                            if (userDataService.addWorkerTask(username, task)) {
                                return new ReceiptTaskRep(ReceiptTaskRepCode.SUCCESS);
                            } else {
                                return new ReceiptTaskRep(ReceiptTaskRepCode.FAIL);
                            }
                        } else {
                            return new ReceiptTaskRep(ReceiptTaskRepCode.FULL);
                        }
                    }else {
                        return new ReceiptTaskRep(ReceiptTaskRepCode.END);
                    }
                } else {
                    return  new ReceiptTaskRep(ReceiptTaskRepCode.HASRECEIPT);
                }
            } else {
                return new ReceiptTaskRep(ReceiptTaskRepCode.NOTASK);
            }
        } else {
            return new ReceiptTaskRep(ReceiptTaskRepCode.NOTFOUND);
        }
    }


}
