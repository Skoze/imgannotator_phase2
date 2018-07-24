package wnderful.imgannotator.controller;

import org.springframework.web.bind.annotation.*;
import wnderful.imgannotator.blserviceImpl.MarkServiceImpl;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.request.mark.GetURLRequest;
import wnderful.imgannotator.request.mark.ImgMarkRequest;

@RestController
@RequestMapping(value = "/service/mark")
public class MarkController {

    final MarkServiceImpl markService = new MarkServiceImpl();

    @RequestMapping(value = "/setMark/{username}", method = RequestMethod.POST)
    public Response setMark(@PathVariable("username") String username, @RequestBody ImgMarkRequest request) {
        Response response = markService.setMark(username,request.getTaskname(),request.getImgID(),request.getMarks());
        return response;
    }

    @RequestMapping(value = "/findURL/{username}", method = RequestMethod.POST)
    public Response findURL(@PathVariable("username") String username,@RequestBody GetURLRequest request) {
        Response response = markService.findURL(username,request.getTaskname(),request.getImgID());
        return response;
    }
}
