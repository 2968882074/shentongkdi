package com.yidu.shentongkdi.dao;

import com.yidu.shentongkdi.entity.Totalwatehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Totalwatehouse)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-28 14:56:39
 */
@Mapper
@Repository
public interface TotalwatehouseDao {
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
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Totalwatehouse> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,Totalwatehouse totalwatehouse);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param totalwatehouse 实例对象
     * @return 对象列表
     */
    List<Totalwatehouse> queryAll(Totalwatehouse totalwatehouse);

    /**
     * 新增数据
     *
     * @param totalwatehouse 实例对象
     * @return 影响行数
     */
    int insert(Totalwatehouse totalwatehouse);

    /**
     * 修改数据
     *
     * @param totalwatehouse 实例对象
     * @return 影响行数
     */
    int update(Totalwatehouse totalwatehouse);

    /**
     * 通过主键删除数据
     *
     * @param twid 主键
     * @return 影响行数
     */
    int deleteById(Integer twid);
    /**
     * 通过主键删除多条数据
     * @param arrid 主键
     * @return 影响行数
     */
    int deleteByIds(String[] arrid);

}