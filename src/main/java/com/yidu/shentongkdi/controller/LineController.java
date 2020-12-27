package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Line;
import com.yidu.shentongkdi.service.LineService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Line)表控制层
 *
 * @author makejava
 * @since 2020-12-27 12:10:39
 */
@RestController
@RequestMapping("line")
public class LineController {
    /**
     * 服务对象
     */
    @Resource
    private LineService lineService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Line selectOne(Integer id) {
        return this.lineService.queryById(id);
    }

}