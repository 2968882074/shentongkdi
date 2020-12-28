package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Branch;
import com.yidu.shentongkdi.service.BranchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 网点信息表控制层
 *
 * @author makejava
 * @since 2020-12-28 14:53:14
 */
@Controller
public class BranchController {
    /**
     * 服务对象
     */
    @Resource
    private BranchService branchService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    @ResponseBody
    public Branch selectOne(Integer id) {
        return this.branchService.queryById(id);
    }

}