package com.yidu.shentongkdi.service.impl;

import com.yidu.shentongkdi.entity.Charge;
import com.yidu.shentongkdi.dao.ChargeDao;
import com.yidu.shentongkdi.service.ChargeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Charge)表服务实现类
 *
 * @author makejava
 * @since 2021-01-04 15:37:33
 */
@Service
public class ChargeServiceImpl implements ChargeService {
    @Resource
    private ChargeDao chargeDao;
    /**
     * 统计行数
     * @return 实例对象
     */
    @Override
    public int count() {
        return  this.chargeDao.count();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param chid 主键
     * @return 实例对象
     */
    @Override
    public Charge queryById(Integer chid) {
        return this.chargeDao.queryById(chid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Charge> queryAllByLimit(int offset, int limit,String chargename) {
        return this.chargeDao.queryAllByLimit(offset, limit,chargename);
    }

    /**
     * 新增数据
     *
     * @param charge 实例对象
     * @return 实例对象
     */
    @Override
    public Charge insert(Charge charge) {
        this.chargeDao.insert(charge);
        return charge;
    }

    /**
     * 修改数据
     *
     * @param charge 实例对象
     * @return 实例对象
     */
    @Override
    public Charge update(Charge charge) {
        this.chargeDao.update(charge);
        return this.queryById(charge.getChid());
    }

    /**
     * 通过主键删除数据
     *
     * @param chid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer chid) {
        return this.chargeDao.deleteById(chid) > 0;
    }
}