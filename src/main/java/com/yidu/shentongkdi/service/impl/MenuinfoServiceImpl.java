package com.yidu.shentongkdi.service.impl;

import com.yidu.shentongkdi.entity.Menuinfo;
import com.yidu.shentongkdi.dao.MenuinfoDao;
import com.yidu.shentongkdi.service.MenuinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.*;
import java.util.List;

/**
 * (Menuinfo)表服务实现类
 *
 * @author makejava
 * @since 2020-12-29 16:16:03
 */
@Service("menuinfoService")
public class MenuinfoServiceImpl implements MenuinfoService {
    @Resource
    private MenuinfoDao menuinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param menuid 主键
     * @return 实例对象
     */
    @Override
    public Menuinfo queryById(String menuid) {
        return this.menuinfoDao.queryById(menuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param menuinfo 查询条件
     * @return 对象列表
     */
    @Override
    public List<Menuinfo> queryAllByLimit(int offset, int limit,Menuinfo menuinfo) {
        return this.menuinfoDao.queryAllByLimit(offset, limit,menuinfo);
    }

    /**
     * 得到数量可根据条件
     * @param menuinfo 查询条件
     * @return 数量
     */
    @Override
    public int count(Menuinfo menuinfo) {
        return this.menuinfoDao.count(menuinfo);
    }

    /**
     * 新增数据
     *
     * @param menuinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Menuinfo insert(Menuinfo menuinfo) {
        this.menuinfoDao.insert(menuinfo);
        return menuinfo;
    }

    /**
     * 修改数据
     *
     * @param menuinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Menuinfo update(Menuinfo menuinfo) {
        this.menuinfoDao.update(menuinfo);
        return this.queryById(menuinfo.getMenuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param menuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String menuid) {
        return this.menuinfoDao.deleteById(menuid) > 0;
    }
}