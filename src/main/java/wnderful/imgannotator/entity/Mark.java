package wnderful.imgannotator.entity;

import com.alibaba.fastjson.JSONObject;

public class Mark {
    private JSONObject mark;

    public Mark() {
    }

    public Mark(JSONObject mark) {
        this.mark = mark;
    }

    public JSONObject getMark() {
        return mark;
    }
}
