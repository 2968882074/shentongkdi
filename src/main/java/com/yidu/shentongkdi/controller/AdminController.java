package com.yidu.shentongkdi.controller;


import com.yidu.shentongkdi.entity.Admin;
import com.yidu.shentongkdi.entity.Menuinfo;
import com.yidu.shentongkdi.entity.Roleinfo;
import com.yidu.shentongkdi.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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


    @ResponseBody
    @RequestMapping("login")
    public String login(Admin admin,HttpServletResponse response){
        //调用登录
        Admin login = adminService.login(admin);
        //判断是否成功
        if(login != null){
            //将用户信息存入session
            request.getSession().setAttribute("admin",login);
            //得到集中好的权限
            List<Menuinfo> merge = adminService.merge(login);
            //将权限存入session
            request.getSession().setAttribute("menulist",merge);
            System.out.println(merge);
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


    /**
     * 分页条件查询
     * @param page  页
     * @param limit  行
     * @param admin  查询条件
     * @return
     */
    @ResponseBody
    @RequestMapping("selectAdminLimit")
    public Map<String,Object> selectLimit(int page, int limit, Admin admin){
        //使用map可以返回layui对应的数据格式
        Map<String,Object> map = new HashMap<>();
        //查询数据
        List<Admin> admins = adminService.queryAllByLimit((page-1)*limit,limit,admin);
        //查询数量
        int count = adminService.count(admin);
        //将数据存入map
        map.put("data",admins);
        map.put("count",count);
        //设置状态
        map.put("code",0);

        //返回mapadminimg
        return map;
    }

    @ResponseBody
    @RequestMapping("addAdminRole")
    public String insert(Admin admin, String roleid, @RequestParam("file") MultipartFile file,HttpServletRequest request){
       try{
           File parent = new File(request.getServletContext().getRealPath("/"));
           //判断文件为空时,使用默认的图片
           if(!file.isEmpty()){
               String dirpath = parent.getParent()+"/resources/static/assets/img/avatar";
               File dir = new File(dirpath);

               //判断文件夹为空时创建一个文件夹
               if(!dir.exists()){
                   dir.mkdir();
               }

               //得到文件名称
               String filename = file.getOriginalFilename();
               //得到文件路径
               String savefilepath = dirpath+"/"+filename;
               //创建文件对象
               File file1 = new File(savefilepath);
               try{
                   //将上传的文件保存到本地
                   file.transferTo(file1);
                   admin.setAdminimg(filename);
               }catch (Exception e){
                   e.printStackTrace();
               }
           }else{
               admin.setAdminimg("mifei.jpg");
           }

            Admin admin1 = adminService.insert(admin,roleid);
            if(admin1 != null){
                return "{\"state\":true}";
            }else{
                return "{\"state\":false}";
            }
        }catch (Exception e){
            return "{\"state\":false}";
        }
    }
}