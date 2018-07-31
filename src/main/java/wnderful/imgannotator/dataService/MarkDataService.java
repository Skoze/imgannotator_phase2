package wnderful.imgannotator.dataService;

import wnderful.imgannotator.entity.Mark;

import java.util.ArrayList;

public interface MarkDataService {

    boolean addMark(String workername, String taskname,String imgID, Mark mark);

    Mark findMark(String workername,String taskname,String imgID);

    ArrayList<Mark> findAllMark(String taskname,String imgID);

    boolean markExist(String workername,String taskname,String imgID);
}
