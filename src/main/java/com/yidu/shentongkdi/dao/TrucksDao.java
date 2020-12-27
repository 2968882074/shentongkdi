package com.yidu.shentongkdi.dao;

import com.yidu.shentongkdi.entity.Trucks;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Trucks)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-27 12:12:12
 */
public interface TrucksDao {

    /**
     * 通过ID查询单条数据
     *
     * @param trid 主键
     * @return 实例对象
     */
    Trucks queryById(Integer trid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Trucks> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param trucks 实例对象
     * @return 对象列表
     */
    List<Trucks> queryAll(Trucks trucks);

    /**
     * 新增数据
     *
     * @param trucks 实例对象
     * @return 影响行数
     */
    int insert(Trucks trucks);

    /**
     * 修改数据
     *
     * @param trucks 实例对象
     * @return 影响行数
     */
    int update(Trucks trucks);

    /**
     * 通过主键删除数据
     *
     * @param trid 主键
     * @return 影响行数
     */
    int deleteById(Integer trid);

}