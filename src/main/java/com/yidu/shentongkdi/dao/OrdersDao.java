package com.yidu.shentongkdi.dao;

import com.yidu.shentongkdi.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Orders)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-28 14:56:39
 */
@Mapper
@Repository
public interface OrdersDao {
    /**
     * 统计行数
     * @param orders 实例对象
     * @return 影响行数
     */
    public int count(Orders orders);

    /**
     * 通过用户ID和订单状态查询数据
     *
     * @param userid 用户id
     * @param state 订单状态
     * @return 实例对象
     */
    List<Orders> selectByUidAndState(Integer userid,Integer state);
    /**
     * 通过ID查询单条数据
     *
     * @param oid 主键
     * @return 实例对象
     */
    Orders queryById(Integer oid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Orders> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("orders") Orders orders);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param orders 实例对象
     * @return 对象列表
     */
    List<Orders> queryAll(Orders orders);

    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 影响行数
     */
    int insert(Orders orders);

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 影响行数
     */
    int update(Orders orders);

    /**
     * 通过主键删除数据
     *
     * @param oid 主键
     * @return 影响行数
     */
    int deleteById(Integer oid);
    /**
     * 通过主键删除多条数据
     * @param arrid 主键
     * @return 影响行数
     */
    int deleteByIds(String[] arrid);

}