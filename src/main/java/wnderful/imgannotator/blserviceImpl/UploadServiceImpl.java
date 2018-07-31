package wnderful.imgannotator.blserviceImpl;

import wnderful.imgannotator.blservice.UploadService;
import wnderful.imgannotator.dataServiceImpl.ImgDataServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.uploadResponseCode.UploadRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.publicData.response.UploadResponse.UploadRep;

public class UploadServiceImpl implements UploadService {

    private ImgDataServiceImpl imgDataService = new ImgDataServiceImpl();

    @Override
    public Response uploadImg(byte[] bytes, String imgID,String taskname) {
        if(imgDataService.imgExist(taskname,imgID)){
            if(imgDataService.uploadImg(taskname,imgID,bytes)){
                return new UploadRep(UploadRepCode.SUCCESS);
            }else {
                return new UploadRep(UploadRepCode.FAIL);
            }
        }else {
           return new UploadRep(UploadRepCode.REPEAT);
        }
    }
}
