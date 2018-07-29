package wnderful.imgannotator.dataServiceImpl;

import wnderful.imgannotator.dao.daoService.*;
import wnderful.imgannotator.dao.data.ProcessData;
import wnderful.imgannotator.dao.data.TaskData;
import wnderful.imgannotator.dao.data.UserData;
import wnderful.imgannotator.dao.data.WorkData;
import wnderful.imgannotator.dataService.UserDataService;
import wnderful.imgannotator.entity.Mark;
import wnderful.imgannotator.entity.Task;
import wnderful.imgannotator.entity.user.Requester;
import wnderful.imgannotator.entity.user.User;
import wnderful.imgannotator.entity.user.Worker;

import java.util.ArrayList;

public class UserDataServiceImpl implements UserDataService {
    private WorkerDaoService workerDaoService = new WorkerDaoService();
    private RequesterDaoService requesterDaoService = new RequesterDaoService();
    private WorkDaoService workDaoService = new WorkDaoService();
    private ProcessDaoService processDaoService = new ProcessDaoService();
    private TaskDaoService taskDaoService = new TaskDaoService();

    //新建用户
    @Override
    public boolean newUser(User user) {
        boolean success = false;
        UserData userData = new UserData(user.getUsername(),user.getPassword(),user.getEmail(),user.getRole(),1000);
        if(user.getRole().equals("worker")){
            success = workerDaoService.addWorker(userData);
        }else if(user.getRole().equals("requester")){
            success = requesterDaoService.addRequester(userData);
        }
        return success;
    }

    //修改工人用户信息
    @Override
    public boolean setWorkerMessage(User worker) {
        boolean success;
        UserData userData = workerDaoService.findWorker(worker.getUsername());
        userData.setEmail(worker.getEmail());
        userData.setPassword(worker.getPassword());
        success = workerDaoService.setWorker(userData);
        return success;
    }

    @Override
    public boolean setRequesterMessage(User requester) {
        boolean success;
        UserData userData = requesterDaoService.findRequester(requester.getUsername());
        userData.setEmail(requester.getEmail());
        userData.setPassword(requester.getPassword());
        success = requesterDaoService.setRequester(userData);
        return success;
    }

    @Override
    public boolean workerExist(String workername) {
        return workerDaoService.findWorker(workername)!=null;
    }

    @Override
    public boolean requesterExist(String requestername) {
        return requesterDaoService.findRequester(requestername)!=null;
    }

    @Override
    public boolean userExist(String username) {
        return (requesterExist(username)||workerExist(username));
    }

    @Override
    public User findUser(String username) {
        if(requesterExist(username)){
            UserData userData = requesterDaoService.findRequester(username);
            return new User(userData.getUsername(),userData.getPassword(),userData.getEmail(),userData.getRole());
        }else if(workerExist(username)){
            UserData userData = workerDaoService.findWorker(username);
            return new User(userData.getUsername(),userData.getPassword(),userData.getEmail(),userData.getRole());
        }else {
            return null;
        }
    }

    @Override
    public Worker findWorker(String workername) {
        UserData userData = workerDaoService.findWorker(workername);
        if(userData == null){
            return null;
        }else {
            Worker worker = new Worker(userData.getUsername(),userData.getPassword(),userData.getEmail(),userData.getPoints());

            //查询完成任务数
            ArrayList<ProcessData> processes = processDaoService.selectByWorker(workername);
            if(processes == null){
                worker.setCompletedTasks(0);
            }else{
                int completedTasks = 0;
                for(int i = 0;i < processes.size();i++){
                    ProcessData processData = processes.get(i);
                    if(processData.getProcess() == processData.getImgsNum()){
                        completedTasks++;
                    }
                }
                worker.setCompletedTasks(completedTasks);
            }

            //查询完成图片数
            ArrayList<WorkData> workDatas = workDaoService.selectbyWorker(workername);
            if(workDatas==null){
                worker.setCompletedImages(0);
            }else {
                worker.setCompletedImages(workDatas.size());
            }

            return worker;

        }
    }

    @Override
    public Requester findRequester(String requestername) {
        UserData userData = requesterDaoService.findRequester(requestername);
        if(userData == null){
            return  null;
        }else {
            Requester requester = new Requester(userData.getUsername(),userData.getPassword(),userData.getEmail(),userData.getPoints());

            //查询发布任务数
            ArrayList<TaskData> taskDatas = taskDaoService.selectByRequester(requestername);
            if(taskDatas == null){
                requester.setReleasedTasks(0);
            }else {
                requester.setReleasedTasks(taskDatas.size());
            }

            return requester;
        }
    }

    @Override
    public boolean addWorkerTask(String workerName, Task task) {
        String processname = task.getTaskname()+"_"+workerName;
        ProcessData processData = new ProcessData(processname,workerName,task.getTaskname(),0,task.getNumberOfImages());
        return processDaoService.addProcess(processData);
    }

    @Override
    public boolean abandonWorkerTask(String workername, Task task) {
        UserData userData = workerDaoService.findWorker(workername);
        String processname = task.getTaskname()+"_"+workername;
        ProcessData processData = processDaoService.findProcess(processname);

        double getPoints = task.getCredits() * processData.getProcess() / processData.getImgsNum();
        userData.setPoints(userData.getPoints() + (int) getPoints);

        return processDaoService.deleteProcess(processname)&&workerDaoService
                .setWorker(userData);
    }
}