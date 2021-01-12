package com.yidu.shentongkdi.dao;

import com.yidu.shentongkdi.entity.Charge;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Charge)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-04 15:37:33
 */
@Mapper
@Repository
public interface ChargeDao {
    /**
     * 统计行数
     * @return 实例对象
     */
    public int count();
    /**
     * 通过ID查询单条数据
     *
     * @param chid 主键
     * @return 实例对象
     */
    Charge queryById(Integer chid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Charge> queryAllByLimit(@Param("offset")int offset, @Param("limit")int limit, @Param("chargetime")String chargetime);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param charge 实例对象
     * @return 对象列表
     */
    List<Charge> queryAll(Charge charge);

    /**
     * 新增数据
     *
     * @param charge 实例对象
     * @return 影响行数
     */
    int insert(Charge charge);

    /**
     * 修改数据
     *
     * @param charge 实例对象
     * @return 影响行数
     */
    int update(Charge charge);

    /**
     * 通过主键删除数据
     *
     * @param chid 主键
     * @return 影响行数
     */
    int deleteById(Integer chid);

}