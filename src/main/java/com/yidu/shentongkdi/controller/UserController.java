package com.yidu.shentongkdi.controller;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.yidu.shentongkdi.entity.User;
import com.yidu.shentongkdi.service.impl.UserServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * (用户)表控制层
 *
 *
 * @author makejava
 * @since 2020-12-28 13:45:32
 */
@Controller
@RequestMapping("user")
public class UserController{
    /**
     * 服务对象
     */
    @Autowired
    private UserServiceImpl userService;

    @ResponseBody
    @RequestMapping("denglu")
    /**
     * 登录
     */
    public String denglu(HttpServletRequest httpServletRequest,User user){
        String msg="";
        User users=userService.denglu(user);
        System.out.println(users);
        if (users==null){
            return "0";
        }
        httpServletRequest.getSession().setAttribute("user",users);
        return "1";
    }
    /**
     * 注册
     * @param
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("zhuce")
    public String zhuce(User user){
        userService.add(user);
        //返回真
        return "true";
    }
}