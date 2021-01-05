package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Driver;
import com.yidu.shentongkdi.service.DriverService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (Driver)货车司机表控制层
 *
 * @author makejava
 * @since 2021-01-04 15:09:19
 */
@Controller
@RequestMapping("driver")
public class DriverController {
    /**
     * 服务对象
     */
    @Autowired
    private DriverService driverService;

    /**
     * 分页查询
     * @param page 页数
     * @param limit  行数
     * @return
     */
    @ResponseBody
    @RequestMapping("selectAll")
    public Map<String ,Object> select(int page,int limit) {
        Map<String,Object> map=new HashMap<>();
        map.put("msg","");
        map.put("code",0);
        map.put("count",driverService.count());
        map.put("data",driverService.queryAllByLimit((page-1)*limit,limit));
        return map;
    }
    @ResponseBody
    @RequestMapping("delete")
  public String delete(String tcid){
        String [] ids=tcid.split("-");
      for (int i = 0; i <ids.length; i++) {
          try {
              driverService.deleteById(Integer.parseInt(ids[i]));
          } catch (NumberFormatException e) {
              e.printStackTrace();
              return "{\"sdate\":false}";
          }

      }
       return "{\"sdate\":true}";
  }
    @ResponseBody
    @RequestMapping("insert")
  public boolean insert(String json){
       JSONObject jsonObject=JSONObject.fromObject(json);
        Driver driver =(Driver) JSONObject.toBean(jsonObject, Driver.class);
        driverService.insert(driver);
        return true;
    }

    /**
     * 修改
     * @param json
     * @return
     */
    @ResponseBody
    @RequestMapping("update")
    public boolean update(String json){
        //转成json数据
     JSONObject jsonObject=JSONObject.fromObject(json);
        Driver driver =(Driver) JSONObject.toBean(jsonObject,Driver.class);
        driverService.update(driver);
        return true;
    }
}