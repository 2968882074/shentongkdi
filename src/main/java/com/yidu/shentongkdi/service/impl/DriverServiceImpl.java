package com.yidu.shentongkdi.service.impl;

import com.yidu.shentongkdi.dao.DriverDao;
import com.yidu.shentongkdi.entity.Driver;
import com.yidu.shentongkdi.service.DriverService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Driver)货车司机表服务实现类
 *
 * @author makejava
 * @since 2021-01-04 15:09:18
 */
@Service("driverService")
public class DriverServiceImpl implements DriverService {
    @Resource
    private DriverDao driverDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tcid 主键
     * @return 实例对象
     */
    @Override
    public Driver queryById(Integer tcid) {
        return this.driverDao.queryById(tcid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Driver> queryAllByLimit(int offset, int limit) {
        return this.driverDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param driver 实例对象
     * @return 实例对象
     */
    @Override
    public Driver insert(Driver driver) {
        this.driverDao.insert(driver);
        return driver;
    }

    /**
     * 修改数据
     *
     * @param driver 实例对象
     * @return 实例对象
     */
    @Override
    public Driver update(Driver driver) {
        this.driverDao.update(driver);
        return this.queryById(driver.getTcid());
    }

    /**
     * 通过主键删除数据
     *
     * @param tcid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer tcid) {
        return this.driverDao.deleteById(tcid) > 0;
    }

    @Override
    public int count() {
        return this.driverDao.count();
    }
}