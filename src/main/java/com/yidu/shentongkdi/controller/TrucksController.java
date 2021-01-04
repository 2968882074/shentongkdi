package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Line;
import com.yidu.shentongkdi.entity.Trucks;
import com.yidu.shentongkdi.service.TrucksService;
import com.yidu.shentongkdi.service.impl.TrucksServiceImpl;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (Trucks)货车管理表控制层
 *
 * @author makejava
 * @since 2020-12-27 12:12:12
 */
@Controller
@RequestMapping("trucks")
public class TrucksController {
    /**
     * 服务对象
     */
    @Autowired
    private TrucksServiceImpl trucksService;

    /**
     * 模糊查询以及分页查询
     * @param page 页数
     * @param limit 行数
     * @param license 车牌号
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("selectAll")
    public Map<String,Object> selectAll(int page,int  limit,String license){
      Map<String,Object> map=new HashMap<>();
        map.put("code", 0);
        map.put("mag", "");
        //调用货车管理表服务接口类的统计方法
        map.put("count",trucksService.count());
        //调用货车管理表服务接口类的分页查询以及模糊查询的方法
        map.put("data",trucksService.queryAllByLimit((page-1)*limit, limit,license));
        //返回map集合
      return map;
  }

    /**
     * 修改货车管理表的信息
     * @param trucks 货车管理表对象
     * @return 成功返回真
     */
   @ResponseBody
    @RequestMapping("update")
    public  String update(Trucks trucks){
       System.out.println(trucks.toString());
       ////调用货车管理表服务接口类的修改方法
       Trucks update=trucksService.update(trucks);
       //返回真
       return "true";
   }
    /**
     * 根据id修改货车管理表的信息
     * @param json 转成json格式数据
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("updateById")
    public boolean updateById(String json){
        //将数据转成json
        JSONObject jsonObject= JSONObject.fromObject(json);
        //将货车管理的实体类装进json
        Trucks trucks=(Trucks) JSONObject.toBean(jsonObject,Trucks.class);
        //调用输出货车管理实体的数据
        System.out.println(trucks.toString());
        //调用货车管理实现接口类的新增方法
        trucksService.update(trucks);
        //返回真
        return true;
    }

    /**
     * 新增线货车管理表的信息
     * @param json 转成json格式数据
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("insert")
    public boolean insert(String json){
        //将数据转成json
        JSONObject jsonObject= JSONObject.fromObject(json);
        //将货车管理的实体类装进json
        Trucks trucks=(Trucks) JSONObject.toBean(jsonObject,Trucks.class);
        //调用输出线路管理实体的数据
        System.out.println(trucks.toString());
        //调用货车管理实现接口类的新增方法
        trucksService.insert(trucks);
        //返回真
        return true;
    }

    /**
     * 根据货车管理表的id删除货车管理表的信息
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("delete")
    public String delete(String trid){
        String [] lids=trid.split("-");
        //循环删除货车管理表中的信息
        for (int i = 0; i < lids.length; i++) {
            try{
                //调用货车管理表的实现接口类的删除方法
                trucksService.deleteById(Integer.parseInt(lids[i]));
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