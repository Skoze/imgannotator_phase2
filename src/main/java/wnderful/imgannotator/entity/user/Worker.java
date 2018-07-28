package wnderful.imgannotator.entity.user;

import wnderful.imgannotator.entity.Task;

import java.util.ArrayList;

public class Worker extends User {
    private ArrayList<Task> receiptTasks;
    private int points;
    private int completedTasks;
    private int completedImages;
    private String role = "worker";

    public Worker() {
        super();
        this.points = 0;
        this.completedImages = 0;
        this.completedTasks = 0;
    }

    public Worker(String username, String password, String email, String role, int points, int completedTasks, int completedImages) {
        super(username, password, email, role);
        this.points = points;
        this.completedTasks = completedTasks;
        this.completedImages = completedImages;
    }

    public Worker(String username, String password, String email, String role, ArrayList<Task> receiptTasks, int points, int completedTasks, int completedImages) {
        super(username, password, email, role);
        this.receiptTasks = receiptTasks;
        this.points = points;
        this.completedTasks = completedTasks;
        this.completedImages = completedImages;
    }

    public ArrayList<Task> getReceiptTasks() {
        return receiptTasks;
    }

    public int getPoints() {
        return points;
    }

    public int getCompletedTasks() {
        return completedTasks;
    }

    public int getCompletedImages() {
        return completedImages;
    }

    @Override
    public String getRole() {
        return role;
    }

    public Task getTask(String taskname) {
        return null;
    }
}
