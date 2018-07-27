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
    public boolean uploadImg(String taskname,Img img, byte[] bytes) {
        return false;
    }
}
