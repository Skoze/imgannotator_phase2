package wnderful.imgannotator.blserviceImpl;

import com.alibaba.fastjson.JSONPObject;
import wnderful.imgannotator.blservice.MarkService;
import wnderful.imgannotator.publicData.reponseCode.markResponseCode.FindMarkRepCode;
import wnderful.imgannotator.publicData.reponseCode.markResponseCode.FindURLRepCode;
import wnderful.imgannotator.publicData.reponseCode.markResponseCode.SetMarkRepCode;
import wnderful.imgannotator.publicData.response.MarkResponse.FindMarkRep;
import wnderful.imgannotator.publicData.response.MarkResponse.FindURLRep;
import wnderful.imgannotator.publicData.response.MarkResponse.SetMarkRep;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.MarkVo.ImgUrlVo;
import wnderful.imgannotator.vo.MarkVo.MarkVo;

public class MarkServiceImpl implements MarkService {
    @Override
    public SetMarkRep setMark(String username, String taskname, String imgID, JSONPObject marks) {
        return new SetMarkRep(SetMarkRepCode.SUCCESS);
    }

    @Override
    public Response findURL(String username, String taskname, String imgID) {
        ImgUrlVo vo = new ImgUrlVo();
        return new FindURLRep(FindURLRepCode.SUCCESS, vo);
    }

    @Override
    public Response findMark(String taskname, String imgID) {
        MarkVo vo = new MarkVo();
        return new FindMarkRep(FindMarkRepCode.SUCCESS,vo);
    }
}