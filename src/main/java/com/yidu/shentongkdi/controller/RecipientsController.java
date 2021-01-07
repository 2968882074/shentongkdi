package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Recipients;
import com.yidu.shentongkdi.service.RecipientsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Recipients)表控制层
 *
 * @author makejava
 * @since 2021-01-07 09:45:46
 */
@RestController
@RequestMapping("recipients")
public class RecipientsController {
    /**
     * 服务对象
     */
    @Resource
    private RecipientsService recipientsService;

    /**
     *  查询所有数据
     * @param recipients 实例对象
     * @return 对象列表
     */
    @RequestMapping("selectAll")
    public List<Recipients> selectAll(Recipients recipients) {
        return this.recipientsService.queryAll(recipients);
    }

}