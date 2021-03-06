package wnderful.imgannotator.dataServiceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import wnderful.imgannotator.dao.daoService.MarksDaoService;
import wnderful.imgannotator.dao.data.mark.MarksData;
import wnderful.imgannotator.dataService.MarkDataService;
import wnderful.imgannotator.entity.Mark;

import java.util.ArrayList;

public class MarkDataServiceImpl implements MarkDataService {
    private MarksDaoService marksDaoService = new MarksDaoService();

    @Override
    public boolean addMark(String workername, String taskname, String imgID, Mark mark) {
        String imgname = taskname + "_" + imgID;
        String markname = imgname + "_" + workername;
        String markStr = JSON.toJSONString(mark.getMark());
        MarksData marksData = new MarksData(markname,workername,imgname,markStr);
        return marksDaoService.addMarks(marksData);
    }

    @Override
    public Mark findMark(String workername, String taskname, String imgID) {
        String marksname = taskname+"_"+imgID+"_"+workername;
        MarksData marksData = marksDaoService.findMarks(marksname);
        if(marksData!=null){
            JSONObject jsonObject = JSON.parseObject(marksData.getMarks());
            return new Mark(jsonObject);
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Mark> findAllMark(String taskname, String imgID) {
        String imgname = taskname + "_" + imgID;
        ArrayList<MarksData> marksDataArrayList = marksDaoService.selectByImg(imgname);
        if(marksDataArrayList != null){
            ArrayList<Mark> marks = new ArrayList<>();
            for(MarksData marksData:marksDataArrayList){
                Mark mark = new Mark(JSON.parseObject(marksData.getMarks()));
                marks.add(mark);
            }
            return marks;
        }else {
            return null ;
        }
    }

    @Override
    public boolean markExist(String workername, String taskname, String imgID) {
        String marksname = taskname+"_"+imgID+"_"+workername;
        return marksDaoService.findMarks(marksname)!=null;
    }
}
