package wnderful.imgannotator.vo.baseVo;

public class WorkerVo {
    private String workerName;
    private int process;

    public WorkerVo() {
        workerName = "";
        process = -1;
    }

    public WorkerVo(String workerName, int process) {
        this.workerName = workerName;
        this.process = process;
    }

    public String getWorkerName() {
        return workerName;
    }

    public int getProcess() {
        return process;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public void setProcess(int process) {
        this.process = process;
    }
}
