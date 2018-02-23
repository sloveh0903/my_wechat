package cn.sun.my_wechat.domain.req;

import cn.sun.my_wechat.domain.BaseMessage;

/**
 * 接收文本消息实体
 */
public class Text extends BaseMessage {

    //文本消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
