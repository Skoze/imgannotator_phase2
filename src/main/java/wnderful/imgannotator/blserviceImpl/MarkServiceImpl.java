package wnderful.imgannotator.blserviceImpl;

import com.alibaba.fastjson.JSONPObject;
import wnderful.imgannotator.blservice.MarkService;
import wnderful.imgannotator.publicData.response.Response;

public class MarkServiceImpl implements MarkService {
    @Override
    public Response setMark(String username, String taskname, String imgID, JSONPObject marks) {
        return new Response();
    }

    @Override
    public Response findURL(String username, String taskname, String imgID) {
        return new Response();
    }
}