package com.yidu.shentongkdi.service.impl;

import com.yidu.shentongkdi.entity.Orders;
import com.yidu.shentongkdi.dao.OrdersDao;
import com.yidu.shentongkdi.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Orders)表服务实现类
 *
 * @author makejava
 * @since 2020-12-28 14:56:39
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersDao ordersDao;

    @Override
    public int count(Orders orders) {
        return this.ordersDao.count(orders);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param oid 主键
     * @return 实例对象
     */
    @Override
    public Orders queryById(Integer oid) {
        return this.ordersDao.queryById(oid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Orders> queryAllByLimit(int offset, int limit,Orders orders) {
        offset-=1;
        return this.ordersDao.queryAllByLimit(offset, limit,orders);
    }

    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    public Orders insert(Orders orders) {
        this.ordersDao.insert(orders);
        return orders;
    }

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    public Orders update(Orders orders) {
        this.ordersDao.update(orders);
        return this.queryById(orders.getOid());
    }

    /**
     * 通过主键删除数据
     *
     * @param oid 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer oid) {
        return this.ordersDao.deleteById(oid);
    }
    /**
     * 通过主键删除多条数据
     * @param arrid 主键
     * @return 影响行数
     */
    @Override
    public int deleteByIds(String[] arrid) {
        return this.ordersDao.deleteByIds(arrid);
    }
}