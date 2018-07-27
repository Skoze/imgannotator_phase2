package wnderful.imgannotator.blserviceImpl;

import wnderful.imgannotator.blservice.UploadService;
import wnderful.imgannotator.publicData.reponseCode.uploadResponseCode.UploadRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.publicData.response.UploadResponse.UploadRep;

public class UploadServiceImpl implements UploadService {

    @Override
    public Response uploadImg(byte[] bytes, String imgID,String taskname) {
        return new UploadRep(UploadRepCode.SUCCESS);
    }
}
