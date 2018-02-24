package cn.sun.my_wechat.service;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface WechatIntelService {

    //获取微信公众号全局token
    public String getAccessToken();

    //创建微信公众号菜单
    public boolean createMenu(String menuJson);

}
