package wnderful.imgannotator.blserviceImpl;

import wnderful.imgannotator.blservice.BaseService;
import wnderful.imgannotator.publicData.response.Response;

public class BaseServiceImpl implements BaseService {
    @Override
    public Response login(String username,String password) {
        return new Response();
    }

    @Override
    public Response signUp(String username,String password,String email) {
        return new Response();
    }

    @Override
    public Response displayDetail(String taskName){
        return new Response();
    }

    @Override
    public Response displayAllTask(){
        return new Response();
    }
}
