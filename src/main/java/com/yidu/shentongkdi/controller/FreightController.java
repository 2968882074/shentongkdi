package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Freight;
import com.yidu.shentongkdi.service.FreightService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Freight)表控制层
 *
 * @author makejava
 * @since 2020-12-27 12:11:48
 */
@RestController
@RequestMapping("freight")
public class FreightController {
    /**
     * 服务对象
     */
    @Resource
    private FreightService freightService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Freight selectOne(Integer id) {
        return this.freightService.queryById(id);
    }

}