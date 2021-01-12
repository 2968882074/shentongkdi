package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.dao.SenderDao;
import com.yidu.shentongkdi.entity.Recipients;
import com.yidu.shentongkdi.entity.Sender;
import com.yidu.shentongkdi.service.SenderService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (Sender)表控制层
 *
 * @author makejava
 * @since 2021-01-11 11:01:00
 */
@Controller
@RequestMapping("/lw")
public class SenderController {
    /**
     * 服务对象
     */
    @Resource
    private SenderService senderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping ("/selectOne")
    public Sender selectOne(Integer id) {
        System.out.println("你可以完全信任布隆");
        return this.senderService.queryById(id);
    }
    @ResponseBody
    @RequestMapping("/getSender")
public  String getSenderOrRecipients(Sender sender, Recipients recipients){
        System.out.println("sender = " + sender+"recipients="+recipients);
        return "ok";
}
@ResponseBody
@RequestMapping("/selectAll")
   public Map<String,Object> selectAll(){

    Map<String,Object> map=new HashMap<>();
       map.put("code", 0);
       map.put("mag", "");
       //调用线路管理表服务接口类的统计方法
       map.put("count", senderService.selectCount());
       //调用线路管理表服务接口类的分页查询以及模糊查询的方法
       map.put("data",senderService.queryAll());
       //返回map集合
       return map;
   }
    /**
     * 根据寄件人表的id删除线路管理表的信息
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("delete")
    public String delete(String seid){
        String [] seids=seid.split("-");
        //循环删除线路管理表中的信息
        for (int i = 0; i < seids.length; i++) {
            try{
                //调用线路管理表的实现接口类的删除方法
                senderService.deleteById(Integer.parseInt(seids[i]));
            }catch (Exception e){
                e.printStackTrace();
                //返回的数据转成json格式
                return "{\"state\":false}";
            }
        }
        //返回真
        return "{\"state\":true}";
    }
    /**
     * 根据id修改寄件人表的信息
     * @param json 转成json格式数据
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("updateById")
    public boolean updateById(String json){
        //将数据转成json
        JSONObject jsonObject= JSONObject.fromObject(json);
        //将线路管理的实体类装进json
        Sender sender=(Sender) JSONObject.toBean(jsonObject,Sender.class);
        //调用输出线路管理实体的数据
        System.out.println(sender.toString());
        //调用线路管理实现接口类的新增方法
        senderService.update(sender);
        //返回真
        return true;
    }
    /**
     * 新增寄件人表的信息
     * @param json 转成json格式数据
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("insert")
    public boolean insert(String json){
        //将数据转成json
        JSONObject jsonObject= JSONObject.fromObject(json);
        //将线路管理的实体类装进json
        Sender line=(Sender) JSONObject.toBean(jsonObject,Sender.class);
        //调用输出线路管理实体的数据
        System.out.println(line.toString());
        //调用线路管理实现接口类的新增方法
        senderService.insert(line);
        //返回真
        return true;
    }
}