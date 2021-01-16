package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Roleinfo;
import com.yidu.shentongkdi.service.RoleinfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Roleinfo)表控制层
 *
 * @author makejava
 * @since 2021-01-07 10:20:38
 */
@RestController
@RequestMapping("admin")
public class RoleinfoController {
    /**
     * 服务对象
     */
    @Resource
    private RoleinfoService roleinfoService;


    /**
     * 分页条件查询
     * @param page  页
     * @param limit  行
     * @param roleinfo  查询条件
     * @return
     */
    @ResponseBody
    @RequestMapping("selectRoleinfoLimit")
    public Map<String,Object> selectLimit(int page, int limit, Roleinfo roleinfo){
        System.out.println(roleinfo);
        //使用map可以返回layui对应的数据格式
        Map<String,Object> map = new HashMap<>();
        //查询数据
        List<Roleinfo> roleinfos = roleinfoService.queryAllByLimit((page-1)*limit, limit, roleinfo);
        //查询数量
        int count = roleinfoService.count(roleinfo);
        //将数据存入map
        map.put("data",roleinfos);
        map.put("count",count);
        //设置状态
        map.put("code",0);

        //返回map
        return map;
    }

    /**
     * 条件件查询
     * @param roleinfo  查询条件
     * @return
     */
    @ResponseBody
    @RequestMapping("selectRoleinfoAll")
    public List<Roleinfo> selectAll(Roleinfo roleinfo){
        System.out.println(roleinfo);
        //使用map可以返回layui对应的数据格式
        Map<String,Object> map = new HashMap<>();
        //查询数据
        List<Roleinfo> roleinfos = roleinfoService.queryAll(roleinfo);
        //返回roleinfos
        return roleinfos;
    }


    @ResponseBody
    @RequestMapping("addRoleMenu")
    public String insert(Roleinfo roleinfo,String menuid){
        try{
            Roleinfo insert = roleinfoService.insert(roleinfo, menuid);
            if(insert != null){
                return "{\"state\":true}";
            }else{
                return "{\"state\":false}";
            }
        }catch (Exception e){
            return "{\"state\":false}";
        }
    }

    @ResponseBody
    @RequestMapping("updateRoleMenu")
    public String update(Roleinfo roleinfo,String menuid){
        try{
            Roleinfo insert = roleinfoService.update(roleinfo, menuid);
            if(insert != null){
                return "{\"state\":true}";
            }else{
                return "{\"state\":false}";
            }
        }catch (Exception e){
            return "{\"state\":false}";
        }
    }


    /**
     * 批量删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteRoleinfo")
    public String delete(String id){
        if(roleinfoService.deleteById(id)) return "{\"state\":true}";
        return "{\"state\":false}";
    }
}