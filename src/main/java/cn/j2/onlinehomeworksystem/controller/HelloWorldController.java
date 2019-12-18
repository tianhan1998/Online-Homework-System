package cn.j2.onlinehomeworksystem.controller;

import cn.j2.onlinehomeworksystem.entity.Result;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @PostMapping("/helloAjax")
    public JSONObject Hello(@RequestBody Result result){
        System.out.println(result);
        JSONObject json;
        json= JSONArray.parseObject(JSONArray.toJSONString(result));
        json.put("msg","ajax后端接受成功");
        return json;
    }
}
