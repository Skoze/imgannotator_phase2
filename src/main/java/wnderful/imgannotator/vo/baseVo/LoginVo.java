package wnderful.imgannotator.vo.baseVo;

import java.io.Serializable;

public class LoginVo implements Serializable {
    private String token = "";

    public LoginVo() {
    }

    public LoginVo(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
