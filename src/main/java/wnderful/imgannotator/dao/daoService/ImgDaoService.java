package wnderful.imgannotator.dao.daoService;

import wnderful.imgannotator.dao.data.ImgData;

import java.util.ArrayList;

public class ImgDaoService {

    public ArrayList selectAll(){
        return null;
    }

    public ArrayList<ImgData> selectByTask(String taskname){
        return null;
    }

    public ImgData findImg(String imgname){
        return new ImgData();
    }

    public boolean setImg(ImgData imgData){
        return true;
    }

    public boolean addImg(ImgData imgData){
        return true;
    }

    public boolean deleteImg(String  imgname){
        return true;
    }
}
