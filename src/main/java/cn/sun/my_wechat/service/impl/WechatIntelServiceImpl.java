package cn.sun.my_wechat.service.impl;

import org.springframework.stereotype.Component;

@Component
public interface WechatIntelServiceImpl {

    //获取微信公众号全局token
    public String getAccessToken();

}
