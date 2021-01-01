package com.yidu.shentongkdi.service.impl;

import com.yidu.shentongkdi.entity.Trucks;
import com.yidu.shentongkdi.dao.TrucksDao;
import com.yidu.shentongkdi.service.TrucksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Trucks)货车线路表服务实现类
 *
 * @author makejava
 * @since 2020-12-27 12:12:12
 */
@Service
public class TrucksServiceImpl implements TrucksService {
    @Resource
    private TrucksDao trucksDao;

    /**
     * 统计行数
     * @return 实例对象
     */
    @Override
    public int count() {
        return this.trucksDao.count();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param trid 主键
     * @return 实例对象
     */
    @Override
    public Trucks queryById(Integer trid) {
        return this.trucksDao.queryById(trid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Trucks> queryAllByLimit(int offset, int limit,String license) {
        return this.trucksDao.queryAllByLimit(offset, limit,license);
    }

    /**
     * 新增数据
     *
     * @param trucks 实例对象
     * @return 实例对象
     */
    @Override
    public Trucks insert(Trucks trucks) {
        this.trucksDao.insert(trucks);
        return trucks;
    }

    /**
     * 修改数据
     *
     * @param trucks 实例对象
     * @return 实例对象
     */
    @Override
    public Trucks update(Trucks trucks) {
        this.trucksDao.update(trucks);
        return this.queryById(trucks.getTrid());
    }

    /**
     * 通过主键删除数据
     *
     * @param trid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer trid) {
        return this.trucksDao.deleteById(trid) > 0;
    }
}