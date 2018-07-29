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

    public Task() {
    }

    public Task(String taskname, Requester requester, String taskDescription, String imgsURL, String releasedTime, int taskTime, String[] taskTag, int credits, int maxWorkers) {
        this.taskname = taskname;
        this.requester = requester;
        this.taskDescription = taskDescription;
        this.imgsURL = imgsURL;
        this.releasedTime = releasedTime;
        this.taskTime = taskTime;
        this.taskTag = taskTag;
        this.credits = credits;
        this.maxWorkers = maxWorkers;
    }

    //发布任务时实例初始化
    public Task(String taskname, Requester requester, String taskDescription, String imgsURL, int taskTime, String[] taskTag, int credits, int maxWorkers) {
        this.taskname = taskname;
        this.requester = requester;
        this.taskDescription = taskDescription;
        this.imgsURL = imgsURL;
        this.taskTime = taskTime;
        this.taskTag = taskTag;
        this.credits = credits;
        this.maxWorkers = maxWorkers;
    }

    public Task(String taskname, String imgsURL, int taskTime, String[] taskTag, int maxWorkers, int recentWorkers) {
        this.taskname = taskname;
        this.imgsURL = imgsURL;
        this.taskTime = taskTime;
        this.taskTag = taskTag;
        this.maxWorkers = maxWorkers;
        this.recentWorkers = recentWorkers;
    }

    public Task(String taskname, ArrayList<Img> imgs, Requester requester, String taskDescription, String imgsURL,
                int numberOfImages, String releasedTime, int taskTime, int process, String[] taskTag, int credits,
                int maxWorkers, int recentWorkers) {
        this.taskname = taskname;
        this.imgs = imgs;
        this.requester = requester;
        this.taskDescription = taskDescription;
        this.imgsURL = imgsURL;
        this.numberOfImages = numberOfImages;
        this.releasedTime = releasedTime;
        this.taskTime = taskTime;
        this.process = process;
        this.taskTag = taskTag;
        this.credits = credits;
        this.maxWorkers = maxWorkers;
        this.recentWorkers = recentWorkers;
    }

    public String getTaskname() {
        return taskname;
    }

    public ArrayList<Img> getImgs() {
        return imgs;
    }

    public Requester getRequester() {
        return requester;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getImgsURL() {
        return imgsURL;
    }

    public int getNumberOfImages() {
        return numberOfImages;
    }

    public String getReleasedTime() {
        return releasedTime;
    }

    public int getTaskTime() {
        return taskTime;
    }

    public int getProcess() {
        return process;
    }

    public String[] getTaskTag() {
        return taskTag;
    }

    public int getCredits() {
        return credits;
    }

    public int getMaxWorkers() {
        return maxWorkers;
    }

    public int getRecentWorkers() {
        return recentWorkers;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskTime(int taskTime) {
        this.taskTime = taskTime;
    }

    public void setTaskTag(String[] taskTag) {
        this.taskTag = taskTag;
    }

    public void setMaxWorkers(int maxWorkers) {
        this.maxWorkers = maxWorkers;
    }

    public void setNumberOfImages(int numberOfImages) {
        this.numberOfImages = numberOfImages;
    }

    public void setRecentWorkers(int recentWorkers) {
        this.recentWorkers = recentWorkers;
    }

    public String getNextImgURL(){
        return null;
    }

    public Img getImg(String imgID){
        return null;
    }
}
