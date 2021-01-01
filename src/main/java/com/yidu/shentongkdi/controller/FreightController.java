package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Freight;
import com.yidu.shentongkdi.entity.Line;
import com.yidu.shentongkdi.service.FreightService;
import com.yidu.shentongkdi.service.impl.FreightServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (Freight)货车线路表控制层
 *
 * @author makejava
 * @since 2020-12-27 12:11:48
 */
@Controller
@RequestMapping("freight")
public class FreightController {
    /**
     * 服务对象货车线路表
     */
    @Resource
    private FreightServiceImpl freightService;
    /**
     * 模糊查询以及分页查询
     * @param page 页数
     * @param limit 行数
     * @param tlid 货车线路表的id
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("selectAll")
    public Map<String,Object> selectAll(int page,int  limit,int tlid){
        //创建一个map集合对象
        Map<String,Object> map=new HashMap<>();
        map.put("code", 0);
        map.put("mag", "");
        //调用线路管理表服务接口类的统计方法
        map.put("count",freightService.count());
        //调用线路管理表服务接口类的分页查询以及模糊查询的方法
        map.put("data",freightService.queryAllByLimit((page-1)*limit, limit,tlid));
        //返回map集合
        return map;

    }
    /**
     * 修改货车线路表的信息
     * @param freight 货车线路表的实体类
     * @return  成功返回真
     */
    @ResponseBody
    @RequestMapping("update")
    public String update(Freight freight){
        System.out.println("line.toString() = " + freight.toString());
        Freight update=freightService.update(freight);
        return "true";
    }

    /**
     * 根据id修改货车线路表的信息
     * @param json 转成json格式数据
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("updateById")
    public boolean updateById(String json){
        //将数据转成json
        JSONObject jsonObject= JSONObject.fromObject(json);
        //将货车线路的实体类装进json
        Freight freight=(Freight) JSONObject.toBean(jsonObject,Freight.class);
        //调用输出货车线路实体的数据
        System.out.println(freight.toString());
        //调用货车线路实现接口类的新增方法
        freightService.update(freight);
        //返回真
        return true;
    }

    /**
     * 新增货车线路表的信息
     * @param json 转成json格式数据
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("insert")
    public boolean insert(String json){
        //将数据转成json
        JSONObject jsonObject= JSONObject.fromObject(json);
        //将货车线路的实体类装进json
        Freight freight=(Freight) JSONObject.toBean(jsonObject,Freight.class);
        //调用输出货车线路实体的数据
        System.out.println(freight.toString());
        //调用货车线路实现接口类的新增方法
        freightService.insert(freight);
        //返回真
        return true;
    }

    /**
     * 根据货车线路表的id删除货车线路表的信息
     * @param tlid 线路管理表id
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("delete")
    public String delete(String tlid){
        String [] tlids=tlid.split("-");
        for (int i = 0; i < tlids.length; i++) {
            try{
                //调用货车线路表的实现接口类的删除方法
                freightService.deleteById(Integer.parseInt(tlids[i]));
            }catch (Exception e){
                e.printStackTrace();
                return "{\"state\":false}";
            }
        }
        //返回真
        return "{\"state\":true}";
    }

}