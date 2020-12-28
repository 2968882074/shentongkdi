package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Orders;
import com.yidu.shentongkdi.entity.Totalwatehouse;
import com.yidu.shentongkdi.service.OrdersService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (Orders)表控制层
 *
 * @author makejava
 * @since 2020-12-28 14:56:39
 */
@RestController
@RequestMapping("orders")
public class OrdersController {
    /**
     * 服务对象
     */
    @Resource
    private OrdersService ordersService;

    /**
     * 模糊查询以及分页查询
     * @param page 页数
     * @param limit 行数
     * @param where 线路管理的名字
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("selectAll")
    public Map<String,Object> selectAll(int page, int  limit, String where){
        //创建一个map集合对象
        Map<String,Object> map=new HashMap<>();
        map.put("code", 0);
        map.put("mag", "");
        //调用接口类的统计方法
        map.put("count",ordersService.count(where));
        //调用接口类的分页查询以及模糊查询的方法
        map.put("data",ordersService.queryAllByLimit(page, limit,where));
        //返回map集合
        return map;

    }

    /**
     * 修改
     * @param bean 实体类
     * @return  成功返回真
     */
    @ResponseBody
    @RequestMapping("update")
    public String update(Orders bean){
        System.out.println("line.toString() = " + bean.toString());
        Orders update=ordersService.update(bean);
        return "true";
    }

    /**
     * 根据id修改
     * @param json 转成json格式数据
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("updateById")
    public boolean updateById(String json){
        //将数据转成json
        JSONObject jsonObject= JSONObject.fromObject(json);
        //将实体类装进json
        Orders bean=(Orders) JSONObject.toBean(jsonObject,Totalwatehouse.class);
        //输出实体的数据
        System.out.println(bean.toString());
        //调用实现接口类的新增方法
        ordersService.update(bean);
        //返回真
        return true;
    }

    /**
     * 新增
     * @param json 转成json格式数据
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("insert")
    public boolean insert(String json){
        //将数据转成json
        JSONObject jsonObject= JSONObject.fromObject(json);
        //将实体类装进json
        Orders bean=(Orders) JSONObject.toBean(jsonObject,Totalwatehouse.class);
        //输出实体的数据
        System.out.println(bean.toString());
        //调用实现接口类的新增方法
        ordersService.insert(bean);
        //返回真
        return true;
    }

    /**
     * 删除
     * @param id 主键id
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("delete")
    public boolean delete(int id){
        //调用接口类的删除方法
        boolean delete=ordersService.deleteById(id);
        //返回真
        return true;
    }

}