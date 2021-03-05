package com.yidu.shentongkdi.dao;

import com.yidu.shentongkdi.entity.Waybill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Waybill)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-29 14:56:13
 */
@Mapper
@Repository
public interface WaybillDao {
    /**
     * 根据运单号查询运单信息
     * @param wnumber 运单号
     * @return  实例对象
     */
    Waybill queryByWnumber(String wnumber);
    /**
     * 统计行数
     * @return 实例对象
     */
    int count();

    /**
     * 通过ID查询单条数据
     *
     * @param wnumber 主键
     * @return 实例对象
     */
    Waybill queryById(String wnumber);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Waybill> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("wnumber") String wnumber);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param waybill 实例对象
     * @return 对象列表
     */
    List<Waybill> queryAll(Waybill waybill);

    /**
     * 新增数据
     *
     * @param waybill 实例对象
     * @return 影响行数
     */
    int insert(Waybill waybill);

    /**
     * 修改数据
     *
     * @param waybill 实例对象
     * @return 影响行数
     */
    int update(Waybill waybill);

    /**
     * 通过主键删除数据
     *
     * @param wnumber 主键
     * @return 影响行数
     */
    int deleteById(String wnumber);

}