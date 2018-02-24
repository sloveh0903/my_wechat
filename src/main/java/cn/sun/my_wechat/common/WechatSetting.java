package cn.sun.my_wechat.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 微信配置文件参数
 */
@Component
@ConfigurationProperties(prefix = "wechat")
@PropertySource("classpath:wechat.properties")
public class WechatSetting {

    //基础参数
    private String appId;
    private String appsecret;
    private String token;

    //微信接口
    private String access_token_url;
    private String create_menu_url;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccess_token_url() {
        return access_token_url;
    }

    public void setAccess_token_url(String access_token_url) {
        this.access_token_url = access_token_url;
    }

    public String getCreate_menu_url() {
        return create_menu_url;
    }

    public void setCreate_menu_url(String create_menu_url) {
        this.create_menu_url = create_menu_url;
    }
}
