package cn.sun.my_wechat.domain.resp;

import cn.sun.my_wechat.domain.BaseMessage;

/**
 * 回复语音消息
 */
public class VoiceMessage extends BaseMessage {

    //消息类型
    private String MsgType = "voice";

    //通过素材管理中的接口上传多媒体文件，得到的id
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
