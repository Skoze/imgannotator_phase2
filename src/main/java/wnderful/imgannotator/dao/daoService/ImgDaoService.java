package wnderful.imgannotator.dao.daoService;

import com.alibaba.fastjson.JSON;
import wnderful.imgannotator.dao.data.ImgData;
import wnderful.imgannotator.util.FileHelper;

import java.util.ArrayList;

public class ImgDaoService {
    private FileHelper fileHelper = new FileHelper();

    public ArrayList selectAll(){
        return null;
    }

    public ArrayList<ImgData> selectByTask(String taskname){
        ArrayList<String> list = fileHelper.readList("img/");
        ArrayList<ImgData> imgData = new ArrayList<>();
        if(list!=null){
            for(String content:list){
                ImgData imgData1 = JSON.parseObject(content,ImgData.class);
                if(imgData1.getTaskname().equals(taskname)){
                    imgData.add(imgData1);
                }
            }
            return imgData;
        }else {
            return null;
        }
    }

    public ImgData findImg(String imgname){
        selectByTask("taskname");
        if(fileHelper.dataExist("img/"+imgname)){
            String content = fileHelper.read("img/"+imgname+ ".txt");
            ImgData imgData = JSON.parseObject(content,ImgData.class);
            return  imgData;
        }else {
            return null;
        }
    }

    public boolean setImg(ImgData imgData){
        return true;
    }

    public boolean addImg(ImgData imgData){
        String content = JSON.toJSONString(imgData);
        return fileHelper.write("img/"+imgData.getImgname(),content);
    }

    public boolean deleteImg(String  imgname){
        return true;
    }
}
