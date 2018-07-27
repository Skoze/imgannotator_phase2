package wnderful.imgannotator.dataService;

import wnderful.imgannotator.entity.Task;
import wnderful.imgannotator.entity.user.Requester;
import wnderful.imgannotator.entity.user.User;
import wnderful.imgannotator.entity.user.Worker;

public interface UserDataService {
    boolean newWorker(Worker worker);

    boolean newRequester(Requester requester);

    boolean setWorkerMessage(Worker worker);

    boolean setRequesterMessage(Requester requester);

    boolean addWorkerTask(String workerName, Task task);

    boolean abandonWorkerTask(String workername, Task task);

    boolean workerExist(String workername);

    boolean requesterExist(String requestername);

    boolean userExist(String username);

    String findRole(String username);

    User findUser(String username);

    Worker findWorker(String workername);

    Requester findRequester(String requestername);

    String findPassWord(String username);
}
