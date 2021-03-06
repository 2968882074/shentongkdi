package com.yidu.shentongkdi.dao;

import com.yidu.shentongkdi.entity.Freight;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Freight)货车线路表数据库访问层
 *
 * @author makejava
 * @since 2020-12-27 12:11:48
 */
@Mapper
@Repository
public interface FreightDao {
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
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Freight> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("tlid") int tlid);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param freight 实例对象
     * @return 对象列表
     */
    List<Freight> queryAll(Freight freight);

    /**
     * 新增数据
     *
     * @param freight 实例对象
     * @return 影响行数
     */
    int insert(Freight freight);

    /**
     * 修改数据
     *
     * @param freight 实例对象
     * @return 影响行数
     */
    int update(Freight freight);

    /**
     * 通过主键删除数据
     *
     * @param tlid 主键
     * @return 影响行数
     */
    int deleteById(Integer tlid);

}