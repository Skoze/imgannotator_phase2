package wnderful.imgannotator.dataServiceImpl;

import wnderful.imgannotator.dao.daoService.*;
import wnderful.imgannotator.dao.data.ImgData;
import wnderful.imgannotator.dao.data.ProcessData;
import wnderful.imgannotator.dao.data.TaskData;
import wnderful.imgannotator.dao.data.UserData;
import wnderful.imgannotator.dataService.TaskDataService;
import wnderful.imgannotator.entity.Task;
import wnderful.imgannotator.entity.user.Requester;
import wnderful.imgannotator.util.EntityHelper;

import java.util.ArrayList;

public class TaskDataServiceImpl implements TaskDataService {
    private UserDataServiceImpl userDataService = new UserDataServiceImpl();

    private WorkerDaoService workerDaoService = new WorkerDaoService();
    private RequesterDaoService requesterDaoService = new RequesterDaoService();
    private TaskDaoService taskDaoService = new TaskDaoService();
    private ImgDaoService imgDaoService = new ImgDaoService();
    private ProcessDaoService processDaoService = new ProcessDaoService();
    private EntityHelper entityHelper = new EntityHelper();

    //查找任务
    @Override
    public Task findTask(String taskname) {
        TaskData taskData = taskDaoService.findTask(taskname);
        if (taskData == null) {
            return null;
        } else {
            Requester requester = userDataService.findRequester(taskData.getRequestername());
            if (requester == null) {
                return null;
            } else {
                Task task = new Task(taskData.getTaskname(), requester, taskData.getTaskDescription(), taskData.getImgURL(),
                        taskData.getReleasedTime(), taskData.getTaskTime(), taskData.getTaskTag(), taskData.getCredits(), taskData.getMaxWorkers());

                //载入任务图片数
                ArrayList<ImgData> imgData = imgDaoService.selectByTask(taskname);
                if (imgData == null) {
                    task.setNumberOfImages(0);
                } else {
                    task.setNumberOfImages(imgData.size());
                }

                //载入任务工人数
                task.setRecentWorkers(findTaskProcess(taskname));

                return task;
            }
        }
        /*
        //ArrayList<Img> imgs = new ArrayList<Img>();
        //Requester requester = new Requester();
        //String[] tags = new String[1];
        //return new Task(taskname,imgs ,requester,"","imgURL", 0,"",
        //        100, 10,tags,0,0,0);
        */
    }

    //查找工人任务完成进度
    @Override
    public int findProcess(String taskname, String workername) {
        String processname = taskname + "_" + workername;
        ProcessData process = processDaoService.findProcess(processname);
        if (process == null) {
            return -1;
        } else {
            return process.getProcess();
        }
    }

    //查询任务完成进度
    @Override
    public int findTaskProcess(String taskname) {
        ArrayList<ProcessData> processData = processDaoService.selectByTask(taskname);
        if (processData == null) {
            return 0;
        } else {
            return processData.size();
        }
    }

    //查看任务是否存在
    @Override
    public boolean exist(String taskname) {
        return taskDaoService.findTask(taskname) != null;
    }

    //上传任务信息
    @Override
    public boolean uploadTask(Task task) {
        TaskData taskData = new TaskData(task.getTaskname(), task.getRequester().getUsername(), task.getTaskDescription(),
                task.getImgsURL(), "20180801", task.getTaskTime(), task.getTaskTag(), task.getCredits(), task.getMaxWorkers());
        return taskDaoService.addTask(taskData);
    }

    //更改任务信息
    @Override
    public boolean setTaskMessage(Task task) {
        TaskData taskData = new TaskData(task.getTaskname(), task.getRequester().getUsername(), task.getTaskDescription(),
                task.getImgsURL(), task.getReleasedTime(), task.getTaskTime(), task.getTaskTag(), task.getCredits(), task.getMaxWorkers());
        return taskDaoService.setTask(taskData);
    }

    //结束任务
    @Override
    public boolean endTask(String taskname) {
        TaskData taskData = taskDaoService.findTask(taskname);
        if (taskData != null) {
            taskData.setTaskTime(0);
            return taskDaoService.setTask(taskData);
        } else {
            return false;
        }
    }

    //判断工人是否有接受任务
    @Override
    public boolean hasReceiptTask(String taskname, String workername) {
        String processname = taskname + "_" + workername;
        return processDaoService.findProcess(processname) != null;
    }

    //判断任务是否已经结束
    @Override
    public boolean isEnd(String taskname) {
        TaskData taskData = taskDaoService.findTask(taskname);
        return taskData.getTaskTime() == 0;
    }

    //判断工人是否已经完成任务
    @Override
    public boolean isComplete(String taskname, String workername) {
        String processname = taskname + "_" + workername;
        ProcessData processData = processDaoService.findProcess(processname);
        if (processData != null) {
            return processData.getImgsNum() <= processData.getProcess();
        }
        return false;
    }

    //判断任务是否由该发布者发布
    @Override
    public boolean isRelease(String taskname, String requestername) {
        TaskData taskData = taskDaoService.findTask(taskname);
        if (taskData != null) {
            return taskData.getRequestername().equals(requestername);
        }
        return false;
    }

    //查询发布者发布的任务
    @Override
    public ArrayList<Task> findReleaseTasks(String requestername) {
        ArrayList<TaskData> taskData = taskDaoService.selectByRequester(requestername);
        ArrayList<Task> tasks = entityHelper.dataToTasks(taskData);
        if (tasks != null) {
            for(Task task:tasks){
                task.setRecentWorkers(findTaskProcess(task.getTaskname()));
            }
            return tasks;
        } else {
            return null;
        }
        //Task task = new Task("taskname", "imgURL", 0, null, 0, 10);
        //ArrayList<Task> tasks = new ArrayList<Task>();
        //tasks.add(task);
        //return tasks;
    }

    //查询工人接受的任务
    @Override
    public ArrayList<Task> findReceiptTasks(String workername) {
        ArrayList<TaskData> taskDataArrayList = new ArrayList<>();
        ArrayList<ProcessData> processDataArrayList = processDaoService.selectByWorker(workername);

        if (processDataArrayList != null) {
            for (ProcessData processData : processDataArrayList) {
                String taskname = processData.getTaskname();
                TaskData taskData = taskDaoService.findTask(taskname);
                if (taskData != null) {
                    taskDataArrayList.add(taskData);
                }
            }

            ArrayList<Task> tasks = entityHelper.dataToTasks(taskDataArrayList);
            if (tasks != null) {
                for(Task task:tasks){
                    task.setRecentWorkers(findTaskProcess(task.getTaskname()));
                }
                return tasks;
            }
        }
        return null;

        //Task task = new Task("taskname", "imgURL", 1, null, 10, 10);
        //ArrayList<Task> tasks = new ArrayList<Task>();
        //tasks.add(task);
        //return tasks;
    }

    @Override
    public ArrayList<Task> findAllTask() {
        ArrayList<TaskData> taskData = taskDaoService.selectAll();
        if(taskData != null){
            ArrayList<Task> tasks = entityHelper.dataToTasks(taskData);
            if (tasks != null) {
                for(Task task:tasks){
                    task.setRecentWorkers(findTaskProcess(task.getTaskname()));
                }
                return tasks;
            }
        }
        return null;
        //Task task = new Task("taskname", "imgURL", 1, null, 10, 10);
        //ArrayList<Task> tasks = new ArrayList<Task>();
        //tasks.add(task);
        //return tasks;
    }
}

