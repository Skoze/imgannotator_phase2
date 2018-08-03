package wnderful.imgannotator.dataService;

public interface ImgDataService {

    String findAImgURL(String taskname,String workername);

    String findFirstImgURL(String taskname);

    String[] findImgURLs(String taskname);

    boolean imgExist(String taskname,String imgID);

    boolean uploadImg(String taskname,String imgID ,byte[] bytes);

    boolean packageExist(String taskname);

    boolean createfolder(String taskname);

    boolean completeImg(String workername,String taskname,String imgID);

    boolean isComplete(String workername,String taskname,String imgID);
}
