package cn.sun.my_wechat.service;


import cn.sun.my_wechat.common.WechatSetting;
import cn.sun.my_wechat.service.impl.WechatIntelServiceImpl;
import cn.sun.my_wechat.util.HttpClientUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.io.IOException;

public class WechatIntelService implements WechatIntelServiceImpl{

    private static final Logger logger = LoggerFactory.getLogger(WechatIntelService.class);

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

}
