package wnderful.imgannotator.dataServiceImpl;

import wnderful.imgannotator.dao.daoService.MarksDaoService;
import wnderful.imgannotator.dataService.MarkDataService;
import wnderful.imgannotator.entity.Mark;

public class MarkDataServiceImpl implements MarkDataService {
    MarksDaoService marksDaoService = new MarksDaoService();

    public Mark findMark(String workername,String taskname){
        return new Mark();
    }

    @Override
    public boolean setMark(String workername, String taskname, String imgID, Mark mark) {
        return false;
    }
}
