package wnderful.imgannotator.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import wnderful.imgannotator.blserviceImpl.UploadServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.uploadResponseCode.UploadRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.publicData.response.UploadResponse.UploadRep;


@RestController
@RequestMapping(value = "/base/images")
public class ImgController {

    private final UploadServiceImpl uploadService = new UploadServiceImpl();

    @RequestMapping(value = "/upload/{taskname}",method = RequestMethod.POST)
    public Response uploadImg(@PathVariable("taskname") String taskname, MultipartFile imageObject){
        try {
            return uploadService.uploadImg(imageObject.getBytes(),imageObject.getOriginalFilename(),taskname);
        } catch (Exception e) {
            e.printStackTrace();
            return new UploadRep(UploadRepCode.FAIL);
        }
    }
}
