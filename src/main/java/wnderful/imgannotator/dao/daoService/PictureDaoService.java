package wnderful.imgannotator.dao.daoService;

import wnderful.imgannotator.util.FileHelper;

public class PictureDaoService {
    private final FileHelper fileHelper = new FileHelper();

    public boolean findTaskFolder(String taskname){
        return fileHelper.pictureExist(taskname);
    }

    public boolean addTaskFolder(String taskname){
        return fileHelper.newFolder(taskname);
    }

    public boolean addPicture(String taskname,String imgID, byte[] bytes){
        return fileHelper.writeFile(taskname+"/"+ imgID,bytes);
    }
}
