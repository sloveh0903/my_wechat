package cn.sun.my_wechat;

import cn.sun.my_wechat.service.WechatIntelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyWechatApplication.class)
@WebAppConfiguration
public class MyWechatApplicationTests {

	@Autowired
	private WechatIntelService wechatIntelService;

	@Test
	public void contextLoads() {
		System.out.print("hello world");
	}

	@Test
	public void getAccessToken(){
		String token = wechatIntelService.getAccessToken();
		System.out.print("获取微信公众号全局token：" + token);
	}
}
