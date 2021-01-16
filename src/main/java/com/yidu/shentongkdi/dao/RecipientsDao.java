package com.yidu.shentongkdi.dao;

import com.yidu.shentongkdi.entity.Recipients;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Recipients)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-11 14:55:22
 */
@Mapper
@Repository
public interface RecipientsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param reid 主键
     * @return 实例对象
     */
    Recipients queryById(Integer reid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Recipients> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param recipients 实例对象
     * @return 对象列表
     */
    List<Recipients> queryAll(Recipients recipients);

    /**
     * 新增数据
     *
     * @param recipients 实例对象
     * @return 影响行数
     */
    int insert(Recipients recipients);

    /**
     * 修改数据
     *
     * @param recipients 实例对象
     * @return 影响行数
     */
    int update(Recipients recipients);

    /**
     * 通过主键删除数据
     *
     * @param reid 主键
     * @return 影响行数
     */
    int deleteById(Integer reid);

}