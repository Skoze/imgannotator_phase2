package wnderful.imgannotator.dataService;

import wnderful.imgannotator.dao.data.UserData;

import java.util.Map;

public interface UserDataService {
    boolean saveUser(UserData userData);

    UserData findUser(String username);

    Map getAllUser();
}
