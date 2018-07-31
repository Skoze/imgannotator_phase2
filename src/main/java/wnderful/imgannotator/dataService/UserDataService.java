package wnderful.imgannotator.dataService;

import wnderful.imgannotator.entity.Task;
import wnderful.imgannotator.entity.user.Requester;
import wnderful.imgannotator.entity.user.User;
import wnderful.imgannotator.entity.user.Worker;

import java.util.ArrayList;

public interface UserDataService {
    boolean newUser(User user);

    boolean setWorkerMessage(User worker);

    boolean setRequesterMessage(User requester);

    boolean addWorkerTask(String workerName, Task task);

    boolean workerExist(String workername);

    boolean requesterExist(String requestername);

    boolean userExist(String username);

    boolean modifyPoints(int points,String username);

    int settlePoints(String taskname,int totalPoints,int point);

    User findUser(String username);

    Worker findWorker(String workername);

    Requester findRequester(String requestername);

    public ArrayList<Worker> findTaskWorker(String taskName);
}
