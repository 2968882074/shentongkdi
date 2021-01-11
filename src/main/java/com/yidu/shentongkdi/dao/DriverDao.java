package com.yidu.shentongkdi.dao;

import com.yidu.shentongkdi.entity.Driver;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Driver)货车司机表数据库访问层
 *
 * @author makejava
 * @since 2021-01-04 15:09:18
 */
@Mapper
@Repository
public interface DriverDao {

    /**
     * 通过ID查询单条数据
     *
     * @param tcid 主键
     * @return 实例对象
     */
    Driver queryById(Integer tcid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Driver> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param driver 实例对象
     * @return 对象列表
     */
    List<Driver> queryAll(Driver driver);

    /**
     * 新增数据
     *
     * @param driver 实例对象
     * @return 影响行数
     */
    int insert(Driver driver);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Driver> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Driver> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Driver> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Driver> entities);

    /**
     * 修改数据
     *
     * @param driver 实例对象
     * @return 影响行数
     */
    int update(Driver driver);

    /**
     * 通过主键删除数据
     *
     * @param tcid 主键
     * @return 影响行数
     */
    int deleteById(Integer tcid);
    /**
     * 统计
     * @return
     */
    int count();
}