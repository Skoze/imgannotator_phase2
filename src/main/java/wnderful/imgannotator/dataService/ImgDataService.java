package wnderful.imgannotator.dataService;

import wnderful.imgannotator.entity.Img;

public interface ImgDataService {
    Img findImg(String taskname,String imgID);

    Img findFirstImg(String taskname);

    boolean uploadImg(String taskname,Img img ,byte[] bytes);
}
