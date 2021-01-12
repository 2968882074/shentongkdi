package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.dao.SenderDao;
import com.yidu.shentongkdi.entity.Recipients;
import com.yidu.shentongkdi.entity.Sender;
import com.yidu.shentongkdi.service.SenderService;
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
   public Map<String,Object> selectAll(Sender sender){
    Map<String,Object> map=new HashMap<>();
       map.put("code", 0);
       map.put("mag", "");
       //调用线路管理表服务接口类的统计方法
       map.put("count", 10);
       //调用线路管理表服务接口类的分页查询以及模糊查询的方法
       map.put("data",senderService.queryAll(sender));
       //返回map集合
       return map;
   }


}