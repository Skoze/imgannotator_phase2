package wnderful.imgannotator.dataServiceImpl;

import wnderful.imgannotator.dao.daoService.MarksDaoService;
import wnderful.imgannotator.dataService.MarkDataService;
import wnderful.imgannotator.entity.Mark;

import java.util.ArrayList;

public class MarkDataServiceImpl implements MarkDataService {
    MarksDaoService marksDaoService = new MarksDaoService();

    @Override
    public boolean addMark(String workername, String taskname, String imgID, Mark mark) {
        return false;
    }


    @Override
    public ArrayList<Mark> findAllMark(String taskname, String imgID) {
        Mark mark = new Mark();
        ArrayList<Mark> marks = new ArrayList<Mark>();
        marks.add(mark);
        return marks;
    }
}
