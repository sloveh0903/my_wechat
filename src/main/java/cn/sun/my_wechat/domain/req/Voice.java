package cn.sun.my_wechat.domain.req;

import cn.sun.my_wechat.domain.BaseMessage;

/**
 * 接收语音消息实体
 */
public class Voice extends BaseMessage {

    //语音消息媒体id,可以调用多媒体文件下载接口拉取数据
    private String MediaId;

    //语音格式，如amr，speex等
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
