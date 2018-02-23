package cn.sun.my_wechat.service.impl;

import org.springframework.stereotype.Component;

/**
 * 微信基础服务类接口
 */
@Component
public interface WechatServiceImpl {

    //处理并响应微信公众号消息
    public String processRequest(String request) throws Exception;

}
