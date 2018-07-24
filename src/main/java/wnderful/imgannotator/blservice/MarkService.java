package wnderful.imgannotator.blservice;

import com.alibaba.fastjson.JSONPObject;
import wnderful.imgannotator.publicData.response.Response;

public interface MarkService {
    Response setMark(String username, String taskname, String imgID, JSONPObject marks);

    Response findURL(String username, String taskname, String imgID);
}
