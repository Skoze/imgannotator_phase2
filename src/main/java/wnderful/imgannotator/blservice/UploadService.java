package wnderful.imgannotator.blservice;

import wnderful.imgannotator.publicData.response.Response;

public interface UploadService {
    Response uploadImg(byte[] bytes,String imgID,String taskname);
}
