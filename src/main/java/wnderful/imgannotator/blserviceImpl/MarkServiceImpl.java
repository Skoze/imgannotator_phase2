package wnderful.imgannotator.blserviceImpl;

import com.alibaba.fastjson.JSONObject;
import wnderful.imgannotator.blservice.MarkService;
import wnderful.imgannotator.dataServiceImpl.ImgDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.MarkDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.TaskDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.UserDataServiceImpl;
import wnderful.imgannotator.entity.Mark;
import wnderful.imgannotator.publicData.reponseCode.markResponseCode.FindMarkRepCode;
import wnderful.imgannotator.publicData.reponseCode.markResponseCode.FindURLRepCode;
import wnderful.imgannotator.publicData.reponseCode.markResponseCode.SetMarkRepCode;
import wnderful.imgannotator.publicData.response.MarkResponse.FindMarkRep;
import wnderful.imgannotator.publicData.response.MarkResponse.FindURLRep;
import wnderful.imgannotator.publicData.response.MarkResponse.SetMarkRep;
import wnderful.imgannotator.util.CreateVoHelper;
import wnderful.imgannotator.vo.MarkVo.ImgUrlVo;
import wnderful.imgannotator.vo.MarkVo.MarkVo;

import java.util.ArrayList;

public class MarkServiceImpl implements MarkService {

    private UserDataServiceImpl userDataService = new UserDataServiceImpl();
    private MarkDataServiceImpl markDataService = new MarkDataServiceImpl();
    private TaskDataServiceImpl taskDataService = new TaskDataServiceImpl();
    private ImgDataServiceImpl imgDataService = new ImgDataServiceImpl();
    private CreateVoHelper helper = new CreateVoHelper();

    @Override
    public SetMarkRep setMark(String username, String taskname, String imgID, JSONObject marks) {
        if (userDataService.workerExist(username)) {
            if (taskDataService.findProcess(taskname, username) >= 0) {
                if (!taskDataService.isEnd(taskname)) {
                    if (imgDataService.imgExist(taskname, imgID)) {
                        if (markDataService.addMark(username, taskname, imgID, new Mark(marks))) {
                            return new SetMarkRep(SetMarkRepCode.SUCCESS);
                        } else {
                            return new SetMarkRep(SetMarkRepCode.FAIL);
                        }
                    } else {
                        return new SetMarkRep(SetMarkRepCode.NOIMG);
                    }
                } else {
                    return new SetMarkRep(SetMarkRepCode.END);
                }
            } else {
                return new SetMarkRep(SetMarkRepCode.NOTASK);
            }
        } else {
            return new SetMarkRep(SetMarkRepCode.NOTFOUND);
        }
    }

    @Override
    public FindURLRep findURL(String username, String taskname) {
        if (userDataService.workerExist(username)) {
            if (!taskDataService.isEnd(taskname)) {
                if (taskDataService.findProcess(taskname, username) >= 0) {
                    if (!taskDataService.isComplete(taskname, username)) {
                        String URL = imgDataService.findAImgURL(taskname, username);
                        if (URL != null && (!URL.equals(""))) {
                            ImgUrlVo vo = new ImgUrlVo(URL);
                            return new FindURLRep(FindURLRepCode.SUCCESS, vo);
                        } else {
                            return new FindURLRep(FindURLRepCode.FAIL);
                        }
                    } else {
                        return new FindURLRep(FindURLRepCode.COMPLETE);
                    }
                } else {
                    return new FindURLRep(FindURLRepCode.NOTASK);
                }
            } else {
                return new FindURLRep(FindURLRepCode.END);
            }
        } else {
            return new FindURLRep(FindURLRepCode.NOTFOUND);
        }
    }

    @Override
    public FindMarkRep findMark(String taskname, String imgID, String username) {
        if (userDataService.requesterExist(username)) {
            if (taskDataService.isRelease(taskname, username)) {
                ArrayList<Mark> marks = markDataService.findAllMark(taskname, imgID);
                if (marks != null) {
                    MarkVo vo = helper.createMarkVo(marks);
                    return new FindMarkRep(FindMarkRepCode.SUCCESS, vo);
                } else {
                    return new FindMarkRep(FindMarkRepCode.FAIL);
                }
            } else {
                return new FindMarkRep(FindMarkRepCode.NOTALLOW);
            }
        } else {
            return new FindMarkRep(FindMarkRepCode.NOTFOUND);
        }
    }
}