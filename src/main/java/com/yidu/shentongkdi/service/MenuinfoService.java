package com.yidu.shentongkdi.service;

import com.yidu.shentongkdi.entity.Menuinfo;

import java.awt.*;
import java.util.List;

/**
 * (Menuinfo)表服务接口
 *
 * @author makejava
 * @since 2020-12-29 16:16:03
 */
public interface MenuinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param menuid 主键
     * @return 实例对象
     */
    Menuinfo queryById(String menuid);

    /**
     * 分页条件查询
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param menuinfo 查询条件
     * @return 对象列表
     */
    List<Menuinfo> queryAllByLimit(int offset, int limit,Menuinfo menuinfo);

    /**
     * 得到数量可根据条件
     * @param menuinfo 查询条件
     * @return 数量
     */
    int count(Menuinfo menuinfo);

    /**
     * 新增数据
     *
     * @param menuinfo 实例对象
     * @return 实例对象
     */
    Menuinfo insert(Menuinfo menuinfo);

    /**
     * 修改数据
     *
     * @param menuinfo 实例对象
     * @return 实例对象
     */
    Menuinfo update(Menuinfo menuinfo);

    /**
     * 通过主键删除数据
     *
     * @param menuid 主键
     * @return 是否成功
     */
    boolean deleteById(String menuid);

}