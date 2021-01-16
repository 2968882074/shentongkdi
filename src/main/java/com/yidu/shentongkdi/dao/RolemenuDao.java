package com.yidu.shentongkdi.dao;

import com.yidu.shentongkdi.entity.Rolemenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Rolemenu)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-11 08:40:47   `
 */

@Mapper
@Repository
public interface RolemenuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param rolemenu 主键
     * @return 实例对象
     */
    Rolemenu queryById(Integer rolemenu);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Rolemenu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param rolemenu 实例对象
     * @return 对象列表
     */
    List<Rolemenu> queryAll(Rolemenu rolemenu);


    /**
     * 判断是否存在
     * @param rolemenu
     * @return
     */
    int exists(Rolemenu rolemenu);

    /**
     * 新增数据
     *
     * @param rolemenu 实例对象
     * @return 影响行数
     */
    int insert(Rolemenu rolemenu);

    /**
     * 修改数据
     *
     * @param rolemenu 实例对象
     * @return 影响行数
     */
    int update(Rolemenu rolemenu);

    /**
     * 通过主键删除数据
     *
     * @param rolemenu 主键
     * @return 影响行数
     */
    int deleteById(Integer rolemenu);

    /**
     * 根据角色id删除
     * @param roleid
     * @return
     */
    int deleteByRoleid(int roleid);

}