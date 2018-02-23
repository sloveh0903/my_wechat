package cn.sun.my_wechat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @RequestMapping("/test")
    public String test(){

        String test = "hello world!";

        return test;
    }

}
