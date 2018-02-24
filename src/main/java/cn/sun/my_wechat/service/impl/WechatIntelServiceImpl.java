package cn.sun.my_wechat.service.impl;


import cn.sun.my_wechat.common.WechatSetting;
import cn.sun.my_wechat.service.WechatIntelService;
import cn.sun.my_wechat.util.HttpClientUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Service
public class WechatIntelServiceImpl implements WechatIntelService {

    private static final Logger logger = LoggerFactory.getLogger(WechatIntelServiceImpl.class);

    @Autowired
    private WechatSetting wechatSetting;

    /**
     * 获取微信全局access_token
     * @return
     */
    @Override
    public  String getAccessToken(){
        //读取配置文件中微信基础参数
        String appId = wechatSetting.getAppId();
        String appsecret = wechatSetting.getAppsecret();
        String access_token_url = wechatSetting.getAccess_token_url()
                .replace("APPID",appId)
                .replace("APPSECRET",appsecret);
        logger.info(String.format("微信基础参数：appId=%s ,appsecret=%s ," +
                "access_token_url=%s",appId,appsecret,access_token_url));

        //调用接口获取token
        HttpMethod method = new GetMethod(access_token_url);
        String token = null;
        try {
            String res = HttpClientUtils.httpRequest(method);
            if (!StringUtils.isEmpty(res)){
                JSONObject object = JSON.parseObject(res);
                token = object.getString("access_token");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info(String.format("接口获取token结果：%s",token));
        return token;
    }

    /**
     * 创建微信公众号菜单
     * @param menuJson
     * @return
     */
    @Override
    public boolean createMenu(String menuJson){

        boolean flag = false;

        String token = "7_WHxnbuPEM3zQuDC7R4vxlNWQTXmmjSPWZLNLh1GTWXaTn0gIzOhzapR2gdZSmBHcfrj6c9dSktvPYP335AXIFNT9LobAXzJ7ds_oa5ywsCRigeYNDGGE5pJGGdkBVNbAEAFZR";

        String createMenuUrl = wechatSetting.getCreate_menu_url()
                .replace("ACCESS_TOKEN",token);

        PostMethod postMethod = new PostMethod(createMenuUrl);
        postMethod.setRequestHeader("Pragma:", "no-cache");
        postMethod.setRequestHeader("Cache-Control", "no-cache");
        postMethod.setRequestHeader("Content-Type", "application/json");
        postMethod.setRequestBody(menuJson);
        String res = null;
        try {
            res = HttpClientUtils.httpRequest(postMethod);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject result = JSONObject.parseObject(res);
        System.out.println("创建微信菜单返回结果："+result.toJSONString());
        //成功
        if(result.getIntValue("errcode")==0 && "ok".equals(result.getString("errmsg"))){
            flag = true;
        }
        return flag;
    }

}
