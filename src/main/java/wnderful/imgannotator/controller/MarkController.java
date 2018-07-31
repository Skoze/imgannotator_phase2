package wnderful.imgannotator.controller;

import org.springframework.web.bind.annotation.*;
import wnderful.imgannotator.blserviceImpl.MarkServiceImpl;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.request.mark.*;

@RestController
@RequestMapping(value = "/service/mark")
public class MarkController {

    private final MarkServiceImpl markService = new MarkServiceImpl();

    @RequestMapping(value = "/setMark/{username}", method = RequestMethod.POST)
    public Response setMark(@PathVariable("username") String username, @RequestBody ImgMarkRequest request) {
        return markService.setMark(username,request.getTaskname(),request.getImgID(),request.getMarks());
    }

    @RequestMapping(value = "/findURL/{username}", method = RequestMethod.POST)
    public Response findURL(@PathVariable("username") String username,@RequestBody GetURLRequest request) {
        return markService.findURL(username,request.getTaskname());
    }

    @RequestMapping(value = "/findMark/{username}",method = RequestMethod.POST)
    public Response findMark(@PathVariable("username") String username, @RequestBody FindMarkRequest request){
        return markService.findMark(request.getTaskname(),request.getImgID(),username);
    }

    @RequestMapping(value = "/getMark/{username}",method = RequestMethod.POST)
    public Response getMark(@PathVariable("username") String username, @RequestBody GetMarkRequest request){
        return markService.getMark(request.getTaskname(),request.getImgID(),username);
    }

    @RequestMapping(value = "/completeImg/{username}", method = RequestMethod.POST)
    public Response completeImg(@PathVariable("username") String username, @RequestBody CompleteImgRequest request) {
        return markService.completeImg(username,request.getTaskname(),request.getImgID());
    }
}
