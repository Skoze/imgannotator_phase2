package wnderful.imgannotator.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wnderful.imgannotator.publicData.Response;
import wnderful.imgannotator.request.mark.GetURLRequest;
import wnderful.imgannotator.request.mark.ImgMarkRequest;

@RestController
@RequestMapping(value = "/mark")
public class MarkController {

    @RequestMapping(value = "/setMark", method = RequestMethod.POST)
    public Response setMark(@RequestBody ImgMarkRequest request) {
        return new Response();
    }

    @RequestMapping(value = "/findURL", method = RequestMethod.POST)
    public Response findURL(@RequestBody GetURLRequest request) {
        return new Response();
    }
}
