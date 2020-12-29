package com.yidu.shentongkdi.service;


import com.yidu.shentongkdi.entity.Admin;
import com.yidu.shentongkdi.entity.Menuinfo;

import java.util.HashSet;
import java.util.List;

/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2020-12-13 17:56:19
 */
public interface AdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param adminid 主键
     * @return 实例对象
     */
    Admin queryById(Integer adminid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Admin> queryAllByLimit(int offset, int limit);

    /**
     * 登录
     * @param admin
     * @return
     */
    Admin login(Admin admin);

    /**
     * 将各个角色的权限合并在一起
     * @param admin
     * @return
     */
    List<Menuinfo> merge(Admin admin);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param adminid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer adminid);

}