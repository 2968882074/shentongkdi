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
import net.sf.json.JSON;
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
import java.util.HashMap;
import java.util.Map;

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


    /**
     * 登录
     */
    @ResponseBody
    @RequestMapping("denglu")
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
        System.out.println(user.toString());
        //返回真
        return "true";
    }
    /**
     * 新增
     * @param
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("add")
    public boolean insert(String json){
        //将数据转成json
        JSONObject jsonObject= JSONObject.fromObject(json);
        //将线路管理的实体类装进json
        User user=(User) JSONObject.toBean(jsonObject,User.class);
        //调用输出线路管理实体的数据
        System.out.println(user.toString());
        //调用线路管理实现接口类的新增方法
        userService.add(user);
        //返回真
        return true;
    }

    /**
     * 根据id修改线路管理表的信息
     * @param json 转成json格式数据
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("updateById")
    public boolean updateById(String json){
        //将数据转成json
        JSONObject jsonObject= JSONObject.fromObject(json);
        //将线路管理的实体类装进json
        User user=(User) JSONObject.toBean(jsonObject,User.class);
        //调用输出线路管理实体的数据
        System.out.println(user.toString());
        //调用线路管理实现接口类的新增方法
        userService.update(user);
        //返回真
        return true;
    }


    /**
     * 模糊查询以及分页查询
     * @param page 页数
     * @param limit 行数
     * @param username 线路管理的名字
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("selectAll")
    public Map<String,Object> selectAll(int page,int  limit,String username){
        //创建一个map集合对象
        Map<String,Object> map=new HashMap<>();
        map.put("code", 0);
        map.put("mag", "");
        //调用线路管理表服务接口类的统计方法
        map.put("count",userService.count());
        //调用线路管理表服务接口类的分页查询以及模糊查询的方法
        map.put("data",userService.queryAllByLimit((page-1)*limit, limit,username));
        //返回map集合
        return map;
    }

    /**
     * 根据用户管理表的id删除线路管理表的信息
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("delete")
    public String delete(String userid){
        String [] userids=userid.split("-");
        //循环删除线路管理表中的信息
        for (int i = 0; i < userids.length; i++) {
            try{
                //调用线路管理表的实现接口类的删除方法
                userService.deleteById(Integer.parseInt(userids[i]));
            }catch (Exception e){
                e.printStackTrace();
                //返回的数据转成json格式
                return "{\"state\":false}";
            }
        }
        //返回真
        return "{\"state\":true}";
    }

}