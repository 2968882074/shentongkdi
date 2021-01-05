package com.yidu.shentongkdi.service.impl;

import com.yidu.shentongkdi.entity.Totalwatehouse;
import com.yidu.shentongkdi.dao.TotalwatehouseDao;
import com.yidu.shentongkdi.service.TotalwatehouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Totalwatehouse)表服务实现类
 *
 * @author makejava
 * @since 2020-12-28 14:56:39
 */
@Service("totalwatehouseService")
public class TotalwatehouseServiceImpl implements TotalwatehouseService {
    @Resource
    private TotalwatehouseDao totalwatehouseDao;

    @Override
    public int count(Totalwatehouse totalwatehouse) {
        return this.totalwatehouseDao.count(totalwatehouse);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param twid 主键
     * @return 实例对象
     */
    @Override
    public Totalwatehouse queryById(Integer twid) {
        return this.totalwatehouseDao.queryById(twid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Totalwatehouse> queryAllByLimit(int offset, int limit,Totalwatehouse totalwatehouse) {
       offset-=1;
        return this.totalwatehouseDao.queryAllByLimit(offset, limit,totalwatehouse);
    }

    /**
     * 新增数据
     *
     * @param totalwatehouse 实例对象
     * @return 实例对象
     */
    @Override
    public Totalwatehouse insert(Totalwatehouse totalwatehouse) {
        this.totalwatehouseDao.insert(totalwatehouse);
        return totalwatehouse;
    }

    /**
     * 修改数据
     *
     * @param totalwatehouse 实例对象
     * @return 实例对象
     */
    @Override
    public Totalwatehouse update(Totalwatehouse totalwatehouse) {
        this.totalwatehouseDao.update(totalwatehouse);
        return this.queryById(totalwatehouse.getTwid());
    }

    /**
     * 通过主键删除数据
     *
     * @param twid 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer twid) {
        return this.totalwatehouseDao.deleteById(twid);
    }
    /**
     * 通过主键删除多条数据
     * @param arrid 主键
     * @return 影响行数
     */
    @Override
    public int deleteByIds(String[] arrid) {
        return  this.totalwatehouseDao.deleteByIds(arrid);
    }
}