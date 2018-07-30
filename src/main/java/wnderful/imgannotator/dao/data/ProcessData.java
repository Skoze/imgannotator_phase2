package wnderful.imgannotator.dao.data;

public class ProcessData {
    private String processname;
    private String workername;
    private String taskname;
    private int process;
    private int imgsNum;

    public ProcessData() {
    }

    public ProcessData(String processname, String username, String taskname, int process, int imgsNum) {
        this.processname = processname;
        this.workername = username;
        this.taskname = taskname;
        this.process = process;
        this.imgsNum = imgsNum;
    }

    public String getProcessname() {
        return processname;
    }

    public String getWorkername() {
        return workername;
    }

    public String getTaskname() {
        return taskname;
    }

    public int getProcess() {
        return process;
    }

    public int getImgsNum() {
        return imgsNum;
    }

    public void setProcessname(String processname) {
        this.processname = processname;
    }

    public void setWorkername(String username) {
        this.workername = username;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    public void setImgsNum(int imgsNum) {
        this.imgsNum = imgsNum;
    }
}
