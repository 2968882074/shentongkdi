package com.yidu.shentongkdi.service;

import com.yidu.shentongkdi.entity.Totalwatehouse;
import java.util.List;

/**
 * (Totalwatehouse)表服务接口
 *
 * @author makejava
 * @since 2020-12-28 14:56:39
 */
public interface TotalwatehouseService {
    /**
     * 统计行数
     * @return 实例对象
     */
    public int count(Totalwatehouse totalwatehouse);

    /**
     * 通过ID查询单条数据
     *
     * @param twid 主键
     * @return 实例对象
     */
    Totalwatehouse queryById(Integer twid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Totalwatehouse> queryAllByLimit(int offset, int limit,Totalwatehouse totalwatehouse);

    /**
     * 新增数据
     *
     * @param totalwatehouse 实例对象
     * @return 实例对象
     */
    Totalwatehouse insert(Totalwatehouse totalwatehouse);

    /**
     * 修改数据
     *
     * @param totalwatehouse 实例对象
     * @return 实例对象
     */
    Totalwatehouse update(Totalwatehouse totalwatehouse);

    /**
     * 通过主键删除数据
     *
     * @param twid 主键
     * @return 是否成功
     */
    int deleteById(Integer twid);
    /**
     * 通过主键删除多条数据
     * @param arrid 主键
     * @return 影响行数
     */
    int deleteByIds(String[] arrid);
}