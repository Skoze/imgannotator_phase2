package wnderful.imgannotator.vo.baseVo;

public class LoginVo {
    private String token;

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
