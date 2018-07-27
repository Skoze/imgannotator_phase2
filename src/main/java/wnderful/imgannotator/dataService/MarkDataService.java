package wnderful.imgannotator.dataService;

import wnderful.imgannotator.entity.Mark;

public interface MarkDataService {
    Mark findMark(String workername, String taskname);

    boolean setMark(String workername, String taskname,String imgID, Mark mark);
}
