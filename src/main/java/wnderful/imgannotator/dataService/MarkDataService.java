package wnderful.imgannotator.dataService;

import wnderful.imgannotator.entity.Mark;

import java.util.ArrayList;

public interface MarkDataService {

    boolean addMark(String workername, String taskname,String imgID, Mark mark);

    ArrayList findAllMark(String taskname,String imgID);
}
