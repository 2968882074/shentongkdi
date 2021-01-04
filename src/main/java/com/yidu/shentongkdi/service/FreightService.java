package com.yidu.shentongkdi.service;

import com.yidu.shentongkdi.entity.Freight;
import java.util.List;

/**
 * (Freight)货车线路表服务接口
 *
 * @author makejava
 * @since 2020-12-27 12:11:48
 */
public interface FreightService {
    /**
     * 统计行数
     * @return
     */
    public int count();

    /**
     * 通过ID查询单条数据
     *
     * @param tlid 主键
     * @return 实例对象
     */
    Freight queryById(Integer tlid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Freight> queryAllByLimit(int offset, int limit,int tlid);

    /**
     * 新增数据
     *
     * @param freight 实例对象
     * @return 实例对象
     */
    Freight insert(Freight freight);

    /**
     * 修改数据
     *
     * @param freight 实例对象
     * @return 实例对象
     */
    Freight update(Freight freight);

    /**
     * 通过主键删除数据
     *
     * @param tlid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer tlid);

}