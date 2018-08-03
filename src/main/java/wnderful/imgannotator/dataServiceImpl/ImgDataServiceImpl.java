package wnderful.imgannotator.dataServiceImpl;

import wnderful.imgannotator.dao.daoService.ImgDaoService;
import wnderful.imgannotator.dao.daoService.PictureDaoService;
import wnderful.imgannotator.dao.daoService.ProcessDaoService;
import wnderful.imgannotator.dao.daoService.WorkDaoService;
import wnderful.imgannotator.dao.data.ImgData;
import wnderful.imgannotator.dao.data.ProcessData;
import wnderful.imgannotator.dao.data.WorkData;
import wnderful.imgannotator.dataService.ImgDataService;
import java.util.ArrayList;

public class ImgDataServiceImpl implements ImgDataService {

    private ImgDaoService imgDaoService = new ImgDaoService();
    private WorkDaoService workDaoService = new WorkDaoService();
    private ProcessDaoService processDaoService = new ProcessDaoService();
    private PictureDaoService pictureDaoService = new PictureDaoService();

    //随机返回一张未被标注过的任务图片
    @Override
    public String findAImgURL(String taskname, String workername) {
        ArrayList<ImgData> imgDataArrayList = imgDaoService.selectByTask(taskname);
        ArrayList<String> imgnames = workDaoService.selectImgByWorker(workername);

        if(imgDataArrayList!=null&&imgDataArrayList.size()>0){
            if(imgnames ==null||imgnames.size()==0){
                return imgDataArrayList.get(0).getImgURL();
            }else {
                loop1:
                for(ImgData imgData:imgDataArrayList){
                    for(String imgName:imgnames){
                        if(imgData.getImgname().equals(imgName)){
                            continue loop1;
                        }
                    }
                    return imgData.getImgURL();
                }
                return null;
            }
        }else {
            return null;
        }
    }

    //返回任务的封面图URL（第一张图片）
    @Override
    public String findFirstImgURL(String taskname) {
        ArrayList<ImgData> imgData = imgDaoService.selectByTask(taskname);
        if(imgData!=null){
            if(imgData.size()>0){
                return imgData.get(0).getImgURL();
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    //返回任务图片全部URL
    @Override
    public String[] findImgURLs(String taskname) {
        ArrayList<ImgData> imgData =imgDaoService.selectByTask(taskname);
        if(imgData!=null&&imgData.size()>0){
            String[] URLs = new String[imgData.size()];
            for(int i = 0;i < imgData.size();i++){
                URLs[i] = imgData.get(i).getImgURL();
            }
            return URLs;
        }else {
            return null;
        }
    }

    @Override
    public boolean imgExist(String taskname, String imgID) {
        String imgname = taskname + "_"+imgID;
        return imgDaoService.findImg(imgname)!=null;
    }

    //上传图片
    @Override
    public boolean uploadImg(String taskname,String imgID, byte[] bytes){
        String imgURL = "picture/"+taskname+"/"+ imgID;
        String imgname = taskname +"_"+ imgID;
        ImgData imgData = new ImgData(imgname,imgID,imgURL,taskname);
        if(imgDaoService.addImg(imgData)){
            return pictureDaoService.addPicture(taskname,imgID,bytes);
        }else {
            return false;
        }
    }

    @Override
    public boolean packageExist(String taskname) {
        return pictureDaoService.findTaskFolder(taskname);
    }

    @Override
    public boolean createfolder(String taskname) {
        return pictureDaoService.addTaskFolder(taskname);
    }

    @Override
    public boolean completeImg(String workername, String taskname, String imgID) {
        String imgname = taskname + "_" + imgID;
        String workname = imgname + "_" + workername;
        WorkData workData = new WorkData(workname,workername,imgname);
        if(workDaoService.addWork(workData)){
            String processname = taskname+"_"+ workername;
            ProcessData processData = processDaoService.findProcess(processname);
            if(processData!=null){
                processData.setProcess(processData.getProcess()+1);
                return processDaoService.setProcess(processData);
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public boolean isComplete(String workername, String taskname, String imgID) {
        String workname = taskname+"_"+imgID + "_" + workername;
        return workDaoService.findWork(workname)!=null;
    }
}
