package wnderful.imgannotator.dataServiceImpl;

import wnderful.imgannotator.dataService.ImgDataService;
import wnderful.imgannotator.entity.Img;

public class ImgDataServiceImpl implements ImgDataService {

    @Override
    public Img findImg(String taskname, String imgID) {
        return new Img();
    }

    @Override
    public Img findFirstImg(String taskname) {
        return null;
    }

    @Override
    public String findAImgURL(String taskname, String workername) {
        return "a.img";
    }

    @Override
    public String findFirstImgURL(String taskname) {
        return "picture/a.img";
    }

    @Override
    public boolean uploadImg(String taskname,String imgID, byte[] bytes) {
        return false;
    }
}
