package wnderful.imgannotator.dataService;

public interface ImgDataService {

    String findAImgURL(String taskname,String workername);

    String  findFirstImgURL(String taskname);

    boolean imgExist(String taskname,String imgID);

    boolean uploadImg(String taskname,String imgID ,byte[] bytes);
}
