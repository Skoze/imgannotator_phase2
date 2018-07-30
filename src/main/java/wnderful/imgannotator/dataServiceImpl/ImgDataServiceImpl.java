package wnderful.imgannotator.dataServiceImpl;

import wnderful.imgannotator.dao.daoService.ImgDaoService;
import wnderful.imgannotator.dao.daoService.WorkDaoService;
import wnderful.imgannotator.dao.data.ImgData;
import wnderful.imgannotator.dataService.ImgDataService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ImgDataServiceImpl implements ImgDataService {

    private ImgDaoService imgDaoService = new ImgDaoService();
    private WorkDaoService workDaoService = new WorkDaoService();

    //随机返回一张未被标注过的任务图片
    @Override
    public String findAImgURL(String taskname, String workername) {
        ArrayList<ImgData> imgDataArrayList = imgDaoService.selectByTask(taskname);
        ArrayList<String> imgnames = workDaoService.selectImgByWorker(workername);

        if(imgDataArrayList!=null){
            if(imgnames ==null){
                return imgDataArrayList.get(0).getImgURL();
            }else {
                for(ImgData imgData:imgDataArrayList){
                    for(String imgName:imgnames){
                        if(!imgData.getImgname().equals(imgName)){
                            return imgData.getImgURL();
                        }
                    }
                }
            }
        }
        return null;
    }

    //返回任务的封面图（第一张图片）
    @Override
    public String findFirstImgURL(String taskname) {
        ArrayList<ImgData> imgData = imgDaoService.selectByTask(taskname);
        if(imgData!=null){
            if(imgData.size()>0){
                return imgData.get(0).getImgURL();
            }
        }
        return null;
    }

    @Override
    public boolean imgExist(String taskname, String imgID) {
        String imgname = taskname + "_"+imgID;
        return imgDaoService.findImg(imgname)!=null;
    }

    @Override
    public boolean uploadImg(String taskname,String imgID, byte[] bytes) {
        String imgURL = "picture/"+taskname+"/"+ imgID;
        String imgname = taskname +"_"+ imgID;
        ImgData imgData = new ImgData(imgname,imgID,imgURL,taskname);
        if(imgDaoService.addImg(imgData)){
            try{
                Path path = Paths.get("src/main/resources/static/picture/"+taskname+"/"+ imgID);
                Files.write(path, bytes);
                return true;
            }catch (IOException ex){
                ex.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
