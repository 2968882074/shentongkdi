package com.yidu.shentongkdi.controller;


import com.yidu.shentongkdi.entity.Admin;
import com.yidu.shentongkdi.entity.Menuinfo;
import com.yidu.shentongkdi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2020-12-13 17:56:20
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    @Autowired
    HttpServletRequest request;


    @RequestMapping("login")
    public String login(Admin admin,HttpServletResponse response){
        //调用登录
        Admin login = adminService.login(admin);
        System.out.println(login);
        //判断是否成功
        if(login != null){
            //将用户信息存入session
            request.getSession().setAttribute("admin",login);
            //得到集中好的权限
            List<Menuinfo> merge = adminService.merge(login);
            //将权限存入session
            request.getSession().setAttribute("menuset",merge);


            for (Menuinfo menuinfo : merge) {
                System.out.println(menuinfo);
            }

            //设置cookie
            Cookie cookie = new Cookie("loginstate","true");
            //设置10分钟,最小单位秒
            cookie.setMaxAge(1*60*10);
            //设置作用域,全局
            cookie.setPath("/shentongkdi");
            //添加到Cookie作用域
            response.addCookie(cookie);

            //将用户名存入cookie
            response.addCookie(new Cookie("adminname",login.getAdminname()));

            return "{\"state\":true}";
        }
        return "{\"state\":false}";
    }
}