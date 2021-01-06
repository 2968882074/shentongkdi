package com.yidu.shentongkdi.service;

import com.yidu.shentongkdi.entity.Driver;

import java.util.List;

/**
 * (Driver)货车司机表服务接口
 *
 * @author makejava
 * @since 2021-01-04 15:09:18
 */
public interface DriverService {

    /**
     * 通过ID查询单条数据
     *
     * @param tcid 主键
     * @return 实例对象
     */
    Driver queryById(Integer tcid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Driver> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param driver 实例对象
     * @return 实例对象
     */
    Driver insert(Driver driver);

    /**
     * 修改数据
     *
     * @param driver 实例对象
     * @return 实例对象
     */
    Driver update(Driver driver);

    /**
     * 通过主键删除数据
     *
     * @param tcid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer tcid);
    /**
     * 统计
     * @return 总行数
     */
    int count();

}