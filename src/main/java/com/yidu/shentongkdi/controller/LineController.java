package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Line;
import com.yidu.shentongkdi.service.LineService;
import com.yidu.shentongkdi.service.impl.LineServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * (Line)线路管理表控制层
 *
 * @author makejava
 * @since 2020-12-27 12:10:39
 */
@Controller
@RequestMapping("line")
public class LineController {
    /**
     * 服务对象线路管理表
     */
    @Autowired
    private LineServiceImpl lineService;

    /**
     * 模糊查询以及分页查询
     * @param page 页数
     * @param limit 行数
     * @param linename 线路管理的名字
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("selectAll")
    public Map<String,Object> selectAll(int page,int  limit,String linename){
        //创建一个map集合对象
        Map<String,Object> map=new HashMap<>();
        map.put("code", 0);
        map.put("mag", "");
        //调用线路管理表服务接口类的统计方法
        map.put("count",lineService.count());
        //调用线路管理表服务接口类的分页查询以及模糊查询的方法
        map.put("data",lineService.queryAllByLimit((page-1)*limit, limit,linename));
        //返回map集合
        return map;

    }

    /**
     * 修改线路管理表的信息
     * @param line 线路管理表的实体类
     * @return  成功返回真
     */
    @ResponseBody
    @RequestMapping("update")
    public String update(Line line){
        System.out.println("line.toString() = " + line.toString());
        //调用线路管理表服务接口类的修改方法
        Line update=lineService.update(line);
        //成功返回真
        return "true";
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
        Line line=(Line) JSONObject.toBean(jsonObject,Line.class);
        //调用输出线路管理实体的数据
        System.out.println(line.toString());
        //调用线路管理实现接口类的新增方法
        lineService.update(line);
        //返回真
        return true;
    }

    /**
     * 新增线路管理表的信息
     * @param json 转成json格式数据
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("insert")
    public boolean insert(String json){
        //将数据转成json
        JSONObject jsonObject= JSONObject.fromObject(json);
        //将线路管理的实体类装进json
        Line line=(Line) JSONObject.toBean(jsonObject,Line.class);
        //调用输出线路管理实体的数据
        System.out.println(line.toString());
        //调用线路管理实现接口类的新增方法
        lineService.insert(line);
        //返回真
        return true;
    }

    /**
     * 根据线路管理表的id删除线路管理表的信息
     * @return 成功返回真
     */
     @ResponseBody
    @RequestMapping("delete")
    public String delete(String lid){
         String [] lids=lid.split("-");
         //循环删除线路管理表中的信息
         for (int i = 0; i < lids.length; i++) {
             try{
                 //调用线路管理表的实现接口类的删除方法
                 lineService.deleteById(Integer.parseInt(lids[i]));
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