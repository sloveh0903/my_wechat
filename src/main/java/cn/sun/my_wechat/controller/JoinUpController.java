package cn.sun.my_wechat.controller;

        import cn.sun.my_wechat.common.WechatSetting;
        import cn.sun.my_wechat.service.WechatService;
        import cn.sun.my_wechat.util.SignaUtils;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

/**
 * 接入微信
 */
@RestController
@RequestMapping(value = "/joinUp")
public class JoinUpController {

    @Autowired
    private WechatSetting wechatSetting;
    @Autowired
    private WechatService wechatServiceImpl;

    /**
     * 接入微信
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String paramsCheck(HttpServletRequest request, HttpServletResponse response) {

        //微信签名
        String signature = request.getParameter("signature");
        //时间戳
        String timestamp = request.getParameter("timestamp");
        //随机数
        String nonce = request.getParameter("nonce");
        //随机字符串
        String echostr = request.getParameter("echostr");
        //微信接口配置token
        String token = wechatSetting.getToken();

        //进行signature签名验证
        boolean checkResult = SignaUtils.signatureCheck(signature, token, nonce, timestamp);

        if (checkResult) {
            System.out.println("微信接入成功");
            return echostr;
        } else {
            System.out.println("微信接入失败");
        }
        return null;
    }

    /**
     * 聊天消息接收
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/xml")
    @ResponseBody
    public String getMessage(@RequestBody String request) throws Exception {
        //调用核心业务类接受并处理消息
        String respMessage = wechatServiceImpl.processRequest(request);
        return respMessage;
    }

}
