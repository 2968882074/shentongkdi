package com.yidu.shentongkdi.dao;

import com.yidu.shentongkdi.entity.Pickup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
/**
 * (Pickup)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-05 10:36:20
 */
public interface PickupDao {

    /**
     * 通过ID查询单条数据
     *
     * @param picid 主键
     * @return 实例对象
     */
    Pickup queryById(Integer picid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Pickup> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param pickup 实例对象
     * @return 对象列表
     */
    List<Pickup> queryAll(Pickup pickup);

    /**
     * 新增数据
     *
     * @param pickup 实例对象
     * @return 影响行数
     */
    int insert(Pickup pickup);

    /**
     * 修改数据
     *
     * @param pickup 实例对象
     * @return 影响行数
     */
    int update(Pickup pickup);

    /**
     * 通过主键删除数据
     *
     * @param picid 主键
     * @return 影响行数
     */
    int deleteById(Integer picid);

}