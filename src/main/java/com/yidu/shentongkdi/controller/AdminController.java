package com.yidu.shentongkdi.controller;


import com.yidu.shentongkdi.entity.Admin;
import com.yidu.shentongkdi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2020-12-13 17:56:20
 */
@RestController
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
    public String login(Admin admin){
        System.out.println(admin);
        //调用登录
        Admin login = adminService.login(admin);


        //判断是否成功
        if(login != null){
            request.getSession().setAttribute("admin",login);
            return "{\"state\":true}";
        }
        return "{\"state\":false}";
    }
}