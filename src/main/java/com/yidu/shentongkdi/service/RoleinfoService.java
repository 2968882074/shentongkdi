package com.yidu.shentongkdi.service;

import com.yidu.shentongkdi.entity.Menuinfo;
import com.yidu.shentongkdi.entity.Roleinfo;
import java.util.List;

/**
 * (Roleinfo)表服务接口
 *
 * @author makejava
 * @since 2021-01-07 10:20:38
 */
public interface RoleinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleid 主键
     * @return 实例对象
     */
    Roleinfo queryById(Integer roleid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @Param roleinfo 查询条件
     * @return 对象列表
     */
    List<Roleinfo> queryAllByLimit(int offset, int limit,Roleinfo roleinfo);

    /**
     * 得到数量可根据条件
     * @param roleinfo 查询条件
     * @return 数量
     */
    int count(Roleinfo roleinfo);


    /**
     * 查询多条数据
     *
     * @Param roleinfo 查询条件
     * @return 对象列表
     */
    List<Roleinfo> queryAll(Roleinfo roleinfo);

    /**
     * 新增数据
     *
     * @param roleinfo 实例对象
     * @param menuid 权限id
     * @return 实例对象
     */
    Roleinfo insert(Roleinfo roleinfo,String menuid);

    /**
     * 修改数据
     *
     * @param roleinfo 实例对象
     * @param menuid 权限id
     * @return 实例对象
     */
    Roleinfo update(Roleinfo roleinfo,String menuid);

    /**
     * 通过主键删除数据
     *
     * @param roleid 主键
     * @return 是否成功
     */
    boolean deleteById(String roleid);

}