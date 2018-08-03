package wnderful.imgannotator.blserviceImpl;

import com.alibaba.fastjson.JSONObject;
import wnderful.imgannotator.blservice.MarkService;
import wnderful.imgannotator.dataServiceImpl.ImgDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.MarkDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.TaskDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.UserDataServiceImpl;
import wnderful.imgannotator.entity.Mark;
import wnderful.imgannotator.publicData.reponseCode.markResponseCode.*;
import wnderful.imgannotator.publicData.response.MarkResponse.*;
import wnderful.imgannotator.util.CreateVoHelper;
import wnderful.imgannotator.vo.MarkVo.AMarkVo;
import wnderful.imgannotator.vo.MarkVo.ImgUrlVo;
import wnderful.imgannotator.vo.MarkVo.ImgUrlsVo;
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
                        if (!imgDataService.isComplete(username, taskname, imgID)) {
                            if (markDataService.addMark(username, taskname, imgID, new Mark(marks))) {
                                return new SetMarkRep(SetMarkRepCode.SUCCESS);
                            } else {
                                return new SetMarkRep(SetMarkRepCode.FAIL);
                            }
                        } else {
                            return new SetMarkRep(SetMarkRepCode.COMPLETE);
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
            if (taskDataService.exist(taskname)) {
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
                return new FindURLRep(FindURLRepCode.NOTEXIST);
            }
        } else {
            return new FindURLRep(FindURLRepCode.NOTFOUND);
        }
    }

    @Override
    public GetURLsRep getURLs(String username, String taskname) {
        if (userDataService.requesterExist(username)) {
            if(taskDataService.exist(taskname)){
                if (taskDataService.isRelease(taskname, username)) {
                    String[] URLs = imgDataService.findImgURLs(taskname);
                    if(URLs!=null&&URLs.length>0){
                        ImgUrlsVo vo = new ImgUrlsVo(URLs);
                        return new GetURLsRep(GetURLsRepCode.SUCCESS,vo);
                    }else {
                        return new GetURLsRep(GetURLsRepCode.FAIL);
                    }
                } else {
                    return new GetURLsRep(GetURLsRepCode.NOALLOW);
                }
            }else {
                return new GetURLsRep(GetURLsRepCode.NOTASK);
            }
        } else {
            return new GetURLsRep(GetURLsRepCode.NOTFOUND);
        }
    }

    @Override
    public FindMarkRep findMark(String taskname, String imgID, String username) {
        if (userDataService.requesterExist(username)) {
            if(taskDataService.exist(taskname)){
                if (taskDataService.isRelease(taskname, username)) {
                    if(imgDataService.imgExist(taskname,imgID)){
                        ArrayList<Mark> marks = markDataService.findAllMark(taskname, imgID);
                        if (marks != null&&marks.size()>0) {
                            MarkVo vo = helper.createMarkVo(marks);
                            if (vo != null) {
                                return new FindMarkRep(FindMarkRepCode.SUCCESS, vo);
                            } else {
                                return new FindMarkRep(FindMarkRepCode.FAIL);
                            }
                        } else {
                            return new FindMarkRep(FindMarkRepCode.SUCCESS);
                        }
                    }else {
                        return new FindMarkRep(FindMarkRepCode.NOIMG);
                    }
                } else {
                    return new FindMarkRep(FindMarkRepCode.NOTALLOW);
                }
            }else {
                return new FindMarkRep(FindMarkRepCode.NOTASK);
            }
        } else {
            return new FindMarkRep(FindMarkRepCode.NOTFOUND);
        }
    }

    @Override
    public GetMarkRep getMark(String taskname, String imgID, String username) {
        if (userDataService.workerExist(username)) {
            if (taskDataService.findProcess(taskname, username) >= 0) {
                if (!taskDataService.isEnd(taskname)) {
                    if (imgDataService.imgExist(taskname, imgID)) {
                        if (!imgDataService.isComplete(username, taskname, imgID)) {
                            if (markDataService.markExist(username, taskname, imgID)) {
                                Mark mark = markDataService.findMark(username, taskname, imgID);
                                if (markDataService.findMark(username, taskname, imgID) != null) {
                                    AMarkVo vo = new AMarkVo(mark.getMark());
                                    return new GetMarkRep(GetMarkRepCode.SUCCESS, vo);
                                } else {
                                    return new GetMarkRep(GetMarkRepCode.FAIL);
                                }
                            } else {
                                return new GetMarkRep(GetMarkRepCode.NOMARK);
                            }
                        } else {
                            return new GetMarkRep(GetMarkRepCode.COMPLETE);
                        }
                    } else {
                        return new GetMarkRep(GetMarkRepCode.NOIMG);
                    }
                } else {
                    return new GetMarkRep(GetMarkRepCode.END);
                }
            } else {
                return new GetMarkRep(GetMarkRepCode.NOTASK);
            }
        } else {
            return new GetMarkRep(GetMarkRepCode.NOTFOUND);
        }
    }


    @Override
    public CompleteImgRep completeImg(String username, String taskname, String imgID) {
        if (userDataService.workerExist(username)) {
            if (taskDataService.findProcess(taskname, username) >= 0) {
                if (!taskDataService.isEnd(taskname)) {
                    if (imgDataService.imgExist(taskname, imgID)) {
                        if (!imgDataService.isComplete(username, taskname, imgID)) {
                            if (markDataService.markExist(username, taskname, imgID)) {
                                if (imgDataService.completeImg(username, taskname, imgID)) {
                                    return new CompleteImgRep(CompleteImgRepCode.SUCCESS);
                                } else {
                                    return new CompleteImgRep(CompleteImgRepCode.FAIL);
                                }
                            } else {
                                return new CompleteImgRep(CompleteImgRepCode.NOMARK);
                            }
                        } else {
                            return new CompleteImgRep(CompleteImgRepCode.COMPLETE);
                        }
                    } else {
                        return new CompleteImgRep(CompleteImgRepCode.NOIMG);
                    }
                } else {
                    return new CompleteImgRep(CompleteImgRepCode.END);
                }
            } else {
                return new CompleteImgRep(CompleteImgRepCode.NOTASK);
            }
        } else {
            return new CompleteImgRep(CompleteImgRepCode.NOTFOUND);
        }
    }
}