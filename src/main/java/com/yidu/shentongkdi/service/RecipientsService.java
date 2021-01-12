package com.yidu.shentongkdi.service;

import com.yidu.shentongkdi.entity.Recipients;
import java.util.List;

/**
 * (Recipients)表服务接口
 *
 * @author makejava
 * @since 2021-01-11 14:55:22
 */
public interface RecipientsService {

    /**
     * 通过ID查询单条数据
     *
     * @param reid 主键
     * @return 实例对象
     */
    Recipients queryById(Integer reid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Recipients> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param recipients 实例对象
     * @return 实例对象
     */
    Recipients insert(Recipients recipients);

    /**
     * 修改数据
     *
     * @param recipients 实例对象
     * @return 实例对象
     */
    Recipients update(Recipients recipients);

    /**
     * 通过主键删除数据
     *
     * @param reid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer reid);

}