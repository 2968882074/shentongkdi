package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Pickup;
import com.yidu.shentongkdi.service.PickupService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Pickup)表控制层
 *
 * @author makejava
 * @since 2021-03-05 10:36:22
 */
@RestController
@RequestMapping("pickup")
public class PickupController {
    /**
     * 服务对象
     */
    @Resource
    private PickupService pickupService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Pickup selectOne(Integer id) {
        return this.pickupService.queryById(id);
    }

}