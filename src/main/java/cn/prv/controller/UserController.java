package cn.prv.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.prv.bean.User;
import cn.prv.service.UserService;
import cn.prv.util.RedisService;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private RedisService redisService;
    
    @RequestMapping("/user")
    public String query() {
       String string=redisService.get("redis_test");
       System.out.println(string);
       return string;
    }
    
    
    @RequestMapping("/query")
    public String queryUser() {
        return this.userService.queryUserById(1);
    }
    
    @RequestMapping("/test")
    public String test() {
        return "可以吗？";
    }
    
    
    @RequestMapping("/del")
    public String deleteUser() {
        if(this.userService.deleteUser(1)) {
            return "删除成功了";
        }
        return "删除失败了";
    }
    
}
