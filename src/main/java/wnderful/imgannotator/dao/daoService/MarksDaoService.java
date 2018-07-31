package wnderful.imgannotator.dao.daoService;

import com.alibaba.fastjson.JSON;
import wnderful.imgannotator.dao.data.mark.MarksData;
import wnderful.imgannotator.util.FileHelper;

import java.util.ArrayList;

public class MarksDaoService {
    private FileHelper fileHelper = new FileHelper();

    public ArrayList selectAll(){
        return null;
    }

    public ArrayList<MarksData> selectByImg(String imgname){
        ArrayList<String> list = fileHelper.readList("mark/");
        ArrayList<MarksData> marksDataArrayList = new ArrayList<>();
        if(list!=null){
            for(String content:list){
                MarksData marksData = JSON.parseObject(content,MarksData.class);
                if(marksData.getImgname().equals(imgname)){
                    marksDataArrayList.add(marksData);
                }
            }
            return marksDataArrayList;
        }else {
            return null;
        }
    }

    public ArrayList selectByWorker(String workername){
        return null;
    }

    public MarksData findMarks(String marksname){
        if(fileHelper.dataExist("mark/"+marksname)){
            String content = fileHelper.read("mark/"+marksname+ ".txt");
            MarksData marksData = JSON.parseObject(content,MarksData.class);
            return  marksData;
        }else {
            return null;
        }
    }

    public boolean setMarks(MarksData marksData){
        return true;
    }

    public boolean addMarks(MarksData marksData){
        String content = JSON.toJSONString(marksData);
        return fileHelper.write("mark/"+marksData.getMarksname(),content);
    }

    public boolean deleteMarks(String marksName){
        return true;
    }
}
