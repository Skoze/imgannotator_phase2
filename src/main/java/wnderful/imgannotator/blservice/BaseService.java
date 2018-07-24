package wnderful.imgannotator.blservice;

import wnderful.imgannotator.publicData.response.Response;

public interface BaseService {
    Response login(String username,String password);

    Response signUp(String username,String password,String email);

    Response displayDetail(String taskName);

    Response displayAllTask();
}
