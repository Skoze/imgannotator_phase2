package wnderful.imgannotator.util;

import com.alibaba.fastjson.JSONObject;
import wnderful.imgannotator.dataServiceImpl.TaskDataServiceImpl;
import wnderful.imgannotator.entity.Mark;
import wnderful.imgannotator.entity.Task;
import wnderful.imgannotator.entity.user.Worker;
import wnderful.imgannotator.vo.MarkVo.MarkVo;
import wnderful.imgannotator.vo.baseVo.DisplayDetailVo;
import wnderful.imgannotator.vo.baseVo.WorkerVo;
import wnderful.imgannotator.vo.taskVo.DisplayTaskVo;
import wnderful.imgannotator.vo.taskVo.TaskVo;

import java.util.ArrayList;

public class CreateVoHelper {
    private TaskDataServiceImpl taskDataService = new TaskDataServiceImpl();

    public DisplayTaskVo createDisplayTaskVo(ArrayList<Task> tasks){
        int size = tasks.size();
        TaskVo[] taskVos = new TaskVo[size];
        for(int i = 0;i < size;i++){
            Task task = tasks.get(i);
            TaskVo taskVo = new TaskVo(task.getTaskname(), task.getImgsURL(),task.getTaskTime(),task.getTaskTag(),task.getRecentWorkers(),task.getMaxWorkers());
            taskVos[i] = taskVo;
        }
        return new DisplayTaskVo(taskVos);
    }

    public MarkVo createMarkVo(ArrayList<Mark> marks){
        int size = marks.size();
        JSONObject[] jsonObjects = new JSONObject[size];
        for(int i = 0;i < size;i++){
            Mark mark = marks.get(i);
            jsonObjects[i] = mark.getMark();
        }
        return new MarkVo(jsonObjects);
    }

    public WorkerVo[] createWorkerVo(ArrayList<Worker> workers,String taskname){
        if(workers != null){
            int size = workers.size();
            WorkerVo[] workerVos = new WorkerVo[size];
            for(int i = 0;i < size;i++){
                Worker worker = workers.get(i);
                int process = taskDataService.findProcess(taskname,worker.getUsername());
                WorkerVo vo = new WorkerVo(worker.getUsername(),process);
                workerVos[i] = vo;
            }
            return workerVos;
        }else {
            System.out.println("NULL");
            return null;
        }
    }

    public DisplayDetailVo createDisplayDetailVo(Task task, WorkerVo[] vos){
        return new DisplayDetailVo(task.getTaskname(), task.getImgsURL(),task.getRequester().getUsername(),
                task.getReleasedTime(),task.getNumberOfImages(),task.getCredits(),task.getTaskDescription(),
                task.getTaskTime(),task.getTaskTag(),task.getRecentWorkers(),task.getMaxWorkers(),vos);
    }
}
