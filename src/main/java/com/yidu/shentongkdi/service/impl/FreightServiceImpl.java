package com.yidu.shentongkdi.service.impl;

import com.yidu.shentongkdi.entity.Freight;
import com.yidu.shentongkdi.dao.FreightDao;
import com.yidu.shentongkdi.service.FreightService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Freight)表服务实现类
 *
 * @author makejava
 * @since 2020-12-27 12:11:48
 */
@Service("freightService")
public class FreightServiceImpl implements FreightService {
    @Resource
    private FreightDao freightDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tlid 主键
     * @return 实例对象
     */
    @Override
    public Freight queryById(Integer tlid) {
        return this.freightDao.queryById(tlid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Freight> queryAllByLimit(int offset, int limit) {
        return this.freightDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param freight 实例对象
     * @return 实例对象
     */
    @Override
    public Freight insert(Freight freight) {
        this.freightDao.insert(freight);
        return freight;
    }

    /**
     * 修改数据
     *
     * @param freight 实例对象
     * @return 实例对象
     */
    @Override
    public Freight update(Freight freight) {
        this.freightDao.update(freight);
        return this.queryById(freight.getTlid());
    }

    /**
     * 通过主键删除数据
     *
     * @param tlid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer tlid) {
        return this.freightDao.deleteById(tlid) > 0;
    }
}