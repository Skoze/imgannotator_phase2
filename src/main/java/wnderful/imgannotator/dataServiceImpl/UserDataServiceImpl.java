package wnderful.imgannotator.dataServiceImpl;

import wnderful.imgannotator.dao.daoService.RequesterDaoService;
import wnderful.imgannotator.dao.daoService.WorkerDaoService;
import wnderful.imgannotator.dataService.UserDataService;
import wnderful.imgannotator.entity.Task;
import wnderful.imgannotator.entity.user.Requester;
import wnderful.imgannotator.entity.user.User;
import wnderful.imgannotator.entity.user.Worker;

public class UserDataServiceImpl implements UserDataService {
    WorkerDaoService workerDaoService = new WorkerDaoService();
    RequesterDaoService requesterDaoService = new RequesterDaoService();
    TaskDataServiceImpl taskDataService = new TaskDataServiceImpl();

    @Override
    public boolean newUser(User user) {
        return false;
    }

    @Override
    public boolean setWorkerMessage(User worker) {
        return true;
    }

    @Override
    public boolean setRequesterMessage(User requester) {
        return true;
    }

    @Override
    public boolean workerExist(String workername) {
        return true;
    }

    @Override
    public boolean requesterExist(String requestername) {
        return true;
    }

    @Override
    public boolean userExist(String username) {
        return false;
    }

    @Override
    public String findRole(String username) {
        return null;
    }

    @Override
    public User findUser(String username) {
        return new User();
    }

    @Override
    public Worker findWorker(String workername) {
        return new Worker();
    }

    @Override
    public Requester findRequester(String requestername) {
        return new Requester();
    }

    @Override
    public String findPassWord(String username) {
        return null;
    }

    @Override
    public boolean addWorkerTask(String workerName, Task task) {
        return true;
    }

    @Override
    public boolean abandonWorkerTask(String workername, Task task) {
        return true;
    }
}