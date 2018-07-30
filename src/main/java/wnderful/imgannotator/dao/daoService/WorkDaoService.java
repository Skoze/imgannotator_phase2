package wnderful.imgannotator.dao.daoService;

import com.alibaba.fastjson.JSON;
import wnderful.imgannotator.dao.data.UserData;
import wnderful.imgannotator.dao.data.WorkData;
import wnderful.imgannotator.entity.user.User;
import wnderful.imgannotator.util.FileHelper;

import java.util.ArrayList;

public class WorkDaoService {
    private FileHelper fileHelper = new FileHelper();

    public ArrayList selectAll(){
        return null;
    }

    public ArrayList<String> selectWorkerByImg(String imgname){
        return null;
    }

    public ArrayList<WorkData> selectByWorker(String workername){
        ArrayList<String> list = fileHelper.readList("work/");
        ArrayList<WorkData> workDataArrayList = new ArrayList<>();
        if(list!=null){
            for(String content:list){
                WorkData workData = JSON.parseObject(content,WorkData.class);
                if(workData.getUsername().equals(workername)){
                    workDataArrayList.add(workData);
                }
            }
            return workDataArrayList;
        }else {
            return null;
        }
    }

    public ArrayList<String> selectImgByWorker(String workername){
        ArrayList<WorkData> workDataArrayList = selectByWorker(workername);
        if(workDataArrayList!=null){
            ArrayList<String> ImgNames = new ArrayList<>();
            for(WorkData workData:workDataArrayList){
                ImgNames.add(workData.getImgname());
            }
            return ImgNames;
        }
        return null;
    }

    public WorkData findWork(String workname){
        return new WorkData();
    }

    public boolean setWork(WorkData workData){
        return true;
    }

    public boolean addWork(WorkData workData){
        String content = JSON.toJSONString(workData);
        fileHelper.write("work/"+workData.getWorkname(),content);
        return true;
    }

    public boolean deleteWork(String  workname){
        return true;
    }
}
