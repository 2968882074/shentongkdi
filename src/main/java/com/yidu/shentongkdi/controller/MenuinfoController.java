package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Menuinfo;
import com.yidu.shentongkdi.service.MenuinfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Menuinfo)表控制层
 *
 * @author makejava
 * @since 2020-12-29 16:16:03
 */
@RestController
@RequestMapping("admin")
public class MenuinfoController {
    /**
     * 服务对象
     */
    @Resource
    private MenuinfoService menuinfoService;

    /**
     * 分页条件查询
     * @param page  页
     * @param limit  行
     * @param menuinfo  查询条件
     * @return
     */
    @ResponseBody
    @RequestMapping("selectMenuinfoLimit")
    public Map<String,Object> selectLimit(int page,int limit,Menuinfo menuinfo){
        //使用map可以返回layui对应的数据格式
        Map<String,Object> map = new HashMap<>();
        //查询数据
        List<Menuinfo> menuinfos = menuinfoService.queryAllByLimit((page-1)*limit, limit, menuinfo);
        //查询数量
        int count = menuinfoService.count(menuinfo);
        //将数据存入map
        map.put("data",menuinfos);
        map.put("count",count);
        //设置状态
        map.put("code",0);

        //返回map
        return map;
    }

    /**
     * 权限新增
     * @param menuinfo 实体
     * @return json
     */
    @ResponseBody
    @RequestMapping("addMenuinfo")
    public String insert(Menuinfo menuinfo){
        try{
            /*执行插入*/
            menuinfoService.insert(menuinfo);
            return "{\"state\":true}";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{\"state\":false}";
    }

    /**
     * 权限修改
     * @param menuinfo 实体
     * @return json
     */
    @ResponseBody
    @RequestMapping("updateMenuinfo")
    public String update(Menuinfo menuinfo){
        try{
            /*执行插入*/
            menuinfoService.update(menuinfo);
            return "{\"state\":true}";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{\"state\":false}";
    }
}