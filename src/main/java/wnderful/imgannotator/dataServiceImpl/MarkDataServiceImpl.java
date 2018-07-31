package wnderful.imgannotator.dataServiceImpl;

import com.alibaba.fastjson.JSON;
import wnderful.imgannotator.dao.daoService.MarksDaoService;
import wnderful.imgannotator.dao.daoService.ProcessDaoService;
import wnderful.imgannotator.dao.daoService.WorkDaoService;
import wnderful.imgannotator.dao.data.ProcessData;
import wnderful.imgannotator.dao.data.WorkData;
import wnderful.imgannotator.dao.data.mark.MarksData;
import wnderful.imgannotator.dataService.MarkDataService;
import wnderful.imgannotator.entity.Mark;

import java.util.ArrayList;

public class MarkDataServiceImpl implements MarkDataService {
    private MarksDaoService marksDaoService = new MarksDaoService();
    private WorkDaoService workDaoService = new WorkDaoService();
    private ProcessDaoService processDaoService = new ProcessDaoService();

    @Override
    public boolean addMark(String workername, String taskname, String imgID, Mark mark) {
        String imgname = taskname + "_" + imgID;
        String markname = imgname + "_" + workername;
        String markStr = JSON.toJSONString(mark.getMark());
        MarksData marksData = new MarksData(markname,workername,imgname,markStr);
        if(marksDaoService.addMarks(marksData)){
            String workname = imgname + "_" + workername;
            WorkData workData = new WorkData(workname,workername,imgname);
            if(workDaoService.addWork(workData)){
                String processname = taskname+"_"+ workername;
                ProcessData processData = processDaoService.findProcess(processname);
                processData.setProcess(processData.getProcess()+1);
                return processDaoService.setProcess(processData);
            }
        }
        return false;
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
}
