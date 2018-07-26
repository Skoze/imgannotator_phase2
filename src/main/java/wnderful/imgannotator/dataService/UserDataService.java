package wnderful.imgannotator.dataService;

import wnderful.imgannotator.entity.User;

import java.util.Map;

public interface UserDataService {
    boolean saveUser(User user);

    User findUser(String username);

    Map getAllUser();
}
