package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Recipients;
import com.yidu.shentongkdi.service.RecipientsService;
import com.yidu.shentongkdi.service.impl.RecipientsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Recipients)表控制层
 *
 * @author makejava
 * @since 2021-01-11 14:55:23
 */
@Controller
@RequestMapping("recipients")
public class RecipientsController {
    /**
     * 服务对象
     */
    @Resource
    private RecipientsServiceImpl recipientsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ResponseBody
    @GetMapping("selectOne")
    public Recipients selectOne(Integer id) {
        return this.recipientsService.queryById(id);
    }


    @ResponseBody
    @RequestMapping("insert")
    public String insert(Recipients recipients){
        recipientsService.insert(recipients);
        return "true";
    }


}