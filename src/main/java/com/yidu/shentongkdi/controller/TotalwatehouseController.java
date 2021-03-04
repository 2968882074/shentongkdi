package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Line;
import com.yidu.shentongkdi.entity.Totalwatehouse;
import com.yidu.shentongkdi.service.TotalwatehouseService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Totalwatehouse)表控制层
 *
 * @author makejava
 * @since 2020-12-28 14:56:39
 */
@RestController
@RequestMapping("totals")
public class TotalwatehouseController {
    /**
     * 服务对象
     */
    @Resource
    private TotalwatehouseService totalwatehouseService;

    @RequestMapping("selectbyid")
    public Totalwatehouse selectbyid(int id){
        return totalwatehouseService.queryById(id);
    }
    /**
     * 模糊查询以及分页查询
     * @param page 页数
     * @param limit 行数
     * @return 成功返回真
     */
    @RequestMapping("selectAll")
    public Map<String,Object> selectAll(int page, int  limit, Totalwatehouse totalwatehouse){
        //创建一个map集合对象
        Map<String,Object> map=new HashMap<>();
        List<Totalwatehouse> totalwatehouses = totalwatehouseService.queryAllByLimit(page, limit, totalwatehouse);
        map.put("code", 0);
        map.put("mag", "");
        //调用接口类的统计方法
        map.put("count",totalwatehouseService.count(totalwatehouse));
        //调用接口类的分页查询以及模糊查询的方法
        map.put("data",totalwatehouses);
        //返回map集合
        return map;

    }

    /**
     * 修改
     * @param total 实体类
     * @return  成功返回真
     */
    @ResponseBody
    @RequestMapping("update")
    public String update(Totalwatehouse total){
        System.out.println("line.toString() = " + total.toString());
        Totalwatehouse update=totalwatehouseService.update(total);
        return "true";
    }

    /**
     * 根据id修改
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("updateById")
    public Map<String,Object> updateById(Totalwatehouse totalwatehouse){
        Map<String,Object> map=new HashMap<>();
        //调用实现接口类的新增方法
        map.put("data",totalwatehouseService.update(totalwatehouse)!=null?"修改成功":"修改失败");
        System.out.println("data="+map.get("data"));
        //返回map
        return map;
    }

    /**
     * 新增
     * @param totalwatehouse 实体类
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("insert") 
    public Map<String,Object> insert(Totalwatehouse totalwatehouse){
        totalwatehouse.setEntertwtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        totalwatehouse.setGotime("暂无");
        Map<String,Object> map=new HashMap<>();
        //调用实现接口类的新增方法
        map.put("data",totalwatehouseService.insert(totalwatehouse)!=null?"新增成功":"新增失败");
        System.out.println("data="+map.get("data"));
        //返回map
        return map;
    }

    /**
     * 删除
     * @param id 主键id
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("delete")
    public Map<String,Object> delete(int id){
        Map<String,Object> map=new HashMap<>();
        //调用接口类的删除方法
        map.put("data",totalwatehouseService.deleteById(id)>0?"删除成功":"删除失败");
        //返回真
        return map;
    }

    /**
     * 删除
     * @param id 主键id
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("deleteByIds")
    public Map<String,Object> deleteByIds(String id){
        String[] ids=id.split(",");
        //调用接口类的删除方法
        Map<String,Object> map=new HashMap<>();
        //调用实现接口类的新增方法
        map.put("data",totalwatehouseService.deleteByIds(ids)>0?"删除成功":"删除失败");
        System.out.println("data="+map.get("data"));
        //返回map
        return map;
    }
}