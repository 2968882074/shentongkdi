package com.yidu.shentongkdi.service;

import com.yidu.shentongkdi.entity.Charge;

import java.util.List;

/**
 * (Charge)表服务接口
 *
 * @author makejava
 * @since 2021-01-04 15:37:33
 */
public interface ChargeService {

    int count();

    /**
     * 通过ID查询单条数据
     *
     * @param chid 主键
     * @return 实例对象
     */
    Charge queryById(Integer chid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Charge> queryAllByLimit(int offset, int limit,String chargetime);

    /**
     * 新增数据
     *
     * @param charge 实例对象
     * @return 实例对象
     */
    Charge insert(Charge charge);

    /**
     * 修改数据
     *
     * @param charge 实例对象
     * @return 实例对象
     */
    Charge update(Charge charge);

    /**
     * 通过主键删除数据
     *
     * @param chid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer chid);

}