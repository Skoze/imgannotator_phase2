package wnderful.imgannotator.vo.userVo;

public class UserMassageVo {
    private String username;
    private String email;
    private int point;

    public UserMassageVo() {
    }

    public UserMassageVo(String username, String email, int point) {
        this.username = username;
        this.email = email;
        this.point = point;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getPoint() {
        return point;
    }
}
