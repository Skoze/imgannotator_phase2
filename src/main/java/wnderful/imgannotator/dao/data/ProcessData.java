package wnderful.imgannotator.dao.data;

public class ProcessData {
    private String processname;
    private String username;
    private String taskname;
    private int process;

    public ProcessData() {
    }

    public ProcessData(String processname, String username, String taskname) {
        this.processname = processname;
        this.username = username;
        this.taskname = taskname;
    }

    public String getProcessname() {
        return processname;
    }

    public String getUsername() {
        return username;
    }

    public String getTaskname() {
        return taskname;
    }

    public int getProcess() {
        return process;
    }

    public void setProcessname(String processname) {
        this.processname = processname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public void setProcess(int process) {
        this.process = process;
    }
}
