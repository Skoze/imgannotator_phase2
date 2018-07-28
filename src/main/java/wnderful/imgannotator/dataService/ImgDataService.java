package wnderful.imgannotator.dataService;

import wnderful.imgannotator.entity.Img;

public interface ImgDataService {
    Img findImg(String taskname,String imgID);

    Img findFirstImg(String taskname);

    String findAImgURL(String taskname,String workername);

    String  findFirstImgURL(String taskname);

    boolean uploadImg(String taskname,String imgID ,byte[] bytes);
}
