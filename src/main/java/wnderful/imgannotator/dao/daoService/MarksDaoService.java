package wnderful.imgannotator.dao.daoService;

import wnderful.imgannotator.dao.data.mark.MarksData;

import java.util.ArrayList;

public class MarksDaoService {
    public ArrayList selectAll(){
        return null;
    }

    public ArrayList selectByImg(String imgname){
        return null;
    }

    public ArrayList selectByWorker(String workername){
        return null;
    }

    public MarksData findMarks(String marksname){
        return new MarksData();
    }

    public boolean setMarks(MarksData marksData){
        return true;
    }

    public boolean addMarks(MarksData marksData){
        return true;
    }

    public boolean deleteMarks(String marksName){
        return true;
    }
}
