package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Sender;
import com.yidu.shentongkdi.service.SenderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Sender)表控制层
 *
 * @author makejava
 * @since 2021-01-07 09:45:47
 */
@RestController
@RequestMapping("sender")
public class SenderController {
    /**
     * 服务对象
     */
    @Resource
    private SenderService senderService;

   @RequestMapping("selectAll")
    public List<Sender> selectAll(Sender sender){
       return senderService.queryAll(sender);
   }
}