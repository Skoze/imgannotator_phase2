package wnderful.imgannotator.entity;

import wnderful.imgannotator.entity.user.Requester;

import java.util.ArrayList;

public class Task {
    private String taskname;
    private ArrayList<Img> imgs;
    private Requester requester;
    private String taskDescription;
    private String imgsURL;
    private int numberOfImages;
    private String releasedTime;
    private int taskTime;
    private int process;
    private String[] taskTag;
    private int credits;
    private int maxWorkers;
    private int recentWorkers;
    private String state;

    public Task(String taskname, Requester requester, String taskDescription, int taskTime, String[] taskTag, int credits, int maxWorkers) {
        this.taskname = taskname;
        this.requester = requester;
        this.taskDescription = taskDescription;
        this.taskTime = taskTime;
        this.taskTag = taskTag;
        this.credits = credits;
        this.maxWorkers = maxWorkers;
    }

    public boolean end(){
        return true;
    }

    public String getNextImgURL(){
        return null;
    }

    public Img getImg(String imgID){
        return null;
    }
}
