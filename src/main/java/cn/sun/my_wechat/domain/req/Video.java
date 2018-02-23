package cn.sun.my_wechat.domain.req;

import cn.sun.my_wechat.domain.BaseMessage;

/**
 * 接收视频消息实体
 */
public class Video extends BaseMessage {

    //视频消息媒体id
    private String MediaId;

    //视频消息缩略图的媒体id
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
