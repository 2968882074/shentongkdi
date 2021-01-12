package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Charge;
import com.yidu.shentongkdi.service.impl.ChargeServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (Charge)表控制层
 *
 * @author makejava
 * @since 2021-01-04 15:37:33
 */
@Controller
@RequestMapping("charge")
public class ChargeController {
    /**
     * 服务对象
     */
    @Resource
    private ChargeServiceImpl chargeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Charge selectOne(Integer id) {
        return this.chargeService.queryById(id);
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
        Charge charge=(Charge) JSONObject.toBean(jsonObject,Charge.class);
        //调用输出线路管理实体的数据
        System.out.println(charge.toString());
        //调用线路管理实现接口类的新增方法
        chargeService.insert(charge);
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
        Charge charge=(Charge) JSONObject.toBean(jsonObject,Charge.class);
        //调用输出线路管理实体的数据
        System.out.println(charge.toString());
        //调用线路管理实现接口类的新增方法
        chargeService.update(charge);
        //返回真
        return true;
    }


    /**
     * 模糊查询以及分页查询
     * @param page 页数
     * @param limit 行数
     * @param chargetime 线路管理的名字
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("selectAll")
    public Map<String,Object> selectAll(int page, int  limit, String chargetime){
        //创建一个map集合对象
        Map<String,Object> map=new HashMap<>();
        map.put("code", 0);
        map.put("mag", "");
        //调用线路管理表服务接口类的统计方法
        map.put("count",chargeService.count());
        //调用线路管理表服务接口类的分页查询以及模糊查询的方法
        map.put("data",chargeService.queryAllByLimit((page-1)*limit, limit,chargetime));
        //返回map集合
        return map;
    }

    /**
     * 根据用户管理表的id删除线路管理表的信息
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("delete")
    public String delete(String chid){
        String [] charges=chid.split("-");
        //循环删除线路管理表中的信息
        for (int i = 0; i < charges.length; i++) {
            try{
                //调用线路管理表的实现接口类的删除方法
                chargeService.deleteById(Integer.parseInt(charges[i]));
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