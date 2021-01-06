package com.yidu.shentongkdi.dao;

import com.yidu.shentongkdi.entity.Sender;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Sender)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-06 10:44:10
 */
public interface SenderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param seid 主键
     * @return 实例对象
     */
    Sender queryById(Integer seid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Sender> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sender 实例对象
     * @return 对象列表
     */
    List<Sender> queryAll(Sender sender);

    /**
     * 新增数据
     *
     * @param sender 实例对象
     * @return 影响行数
     */
    int insert(Sender sender);

    /**
     * 修改数据
     *
     * @param sender 实例对象
     * @return 影响行数
     */
    int update(Sender sender);

    /**
     * 通过主键删除数据
     *
     * @param seid 主键
     * @return 影响行数
     */
    int deleteById(Integer seid);

}