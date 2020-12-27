package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Trucks;
import com.yidu.shentongkdi.service.TrucksService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Trucks)表控制层
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
    @Resource
    private TrucksService trucksService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ResponseBody
    @RequestMapping("selectOne")
    public Trucks selectOne(Integer id) {
        return this.trucksService.queryById(id);
    }

}