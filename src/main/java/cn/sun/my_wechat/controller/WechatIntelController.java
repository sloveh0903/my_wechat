package cn.sun.my_wechat.controller;

import cn.sun.my_wechat.service.WechatIntelService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class WechatIntelController {

    @Autowired
    private WechatIntelService wechatIntelService;

    /**
     * 获取微信全局access_token
     * @return
     */
    @RequestMapping(value = "/getToken",method = RequestMethod.GET)
    @ResponseBody
    public String getAccessToken(){
        String token = wechatIntelService.getAccessToken();
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        return JSON.toJSONString(map,true);
    }

    /**
     * 自定义创建微信菜单
     * @param request 微信菜单 json格式字符串
     * @return
     */
    @RequestMapping(value = "/createMenu",method = RequestMethod.POST,
            produces = "application/json",consumes = "application/json")
    @ResponseBody
    public String createMenu(@RequestBody String request){
        boolean result = wechatIntelService.createMenu(request);
        Map<String,String> map = new HashMap<>();
        map.put("result",String.valueOf(result));
        return JSON.toJSONString(map,true);
    }

}
