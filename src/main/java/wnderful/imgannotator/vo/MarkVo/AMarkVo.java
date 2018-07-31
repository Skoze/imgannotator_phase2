package wnderful.imgannotator.vo.MarkVo;

import com.alibaba.fastjson.JSONObject;

public class AMarkVo {
    private JSONObject aMark;

    public AMarkVo() {
        aMark = new JSONObject();
    }

    public AMarkVo(JSONObject aMark) {
        this.aMark = aMark;
    }

    public JSONObject getaMark() {
        return aMark;
    }

    public void setaMark(JSONObject aMark) {
        this.aMark = aMark;
    }
}
