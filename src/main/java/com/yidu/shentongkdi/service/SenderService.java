package com.yidu.shentongkdi.service;

import com.yidu.shentongkdi.entity.Sender;
import java.util.List;

/**
 * (Sender)表服务接口
 *
 * @author makejava
 * @since 2021-01-11 11:01:00
 */
public interface SenderService {

    /**
     * 通过ID查询单条数据
     *
     * @param seid 主键
     * @return 实例对象
     */
    Sender queryById(Integer seid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Sender> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sender 实例对象
     * @return 实例对象
     */
    Sender insert(Sender sender);

    /**
     * 修改数据
     *
     * @param sender 实例对象
     * @return 实例对象
     */
    Sender update(Sender sender);

    /**
     * 通过主键删除数据
     *
     * @param seid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer seid);
    List<Sender> queryAll();
    /**
     *
     * @return 查询总数
     */
    int selectCount();
}