package wnderful.imgannotator.entity;

import java.util.ArrayList;

public class Img {
    private String imgID;
    private String imgURL;
    private boolean isMarked;
    private ArrayList<Mark> marks;

    public Img() {
    }

    public Img(String imgID, String imgURL) {
        this.imgID = imgID;
        this.imgURL = imgURL;
    }
}
