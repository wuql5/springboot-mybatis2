package com.cn.wuql.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Api(description = "项目主界面接口")
@Controller
@Component
@RequestMapping(value = "/main")
public class mainController {

    @Autowired
    private RedisTemplate redisTemplate;
    public int i = 0;
    @ResponseBody
    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap, HttpSession session) {
        redisTemplate.opsForValue().set("testdata", "12ss");
        return "test";
    }

    @ResponseBody
    @RequestMapping(value = "/getRedisValue")
    public Object getRedisValue(ModelMap modelMap, HttpSession session) {
        return redisTemplate.opsForValue().get("testdata");
    }

    // 定时任务
    // @Scheduled(cron = "0/5 * * * * ? ")
    public void test() {
        System.out.println(i++);
    }
}
