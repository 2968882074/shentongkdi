package com.yidu.shentongkdi.dao;


import com.yidu.shentongkdi.entity.Admin;
import com.yidu.shentongkdi.entity.Roleinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Admin)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-13 17:56:18
 */

@Mapper
@Repository
public interface AdminDao {

    /**
     * 通过ID查询单条数据
     *
     * @param adminid 主键
     * @return 实例对象
     */
    Admin queryById(Integer adminid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param admin 员工实体
     * @return 对象列表
     */
    List<Admin> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,Admin admin);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param admin 实例对象
     * @return 对象列表
     */
    List<Admin> queryAll(Admin admin);

    /**
     * 得到数量可根据条件
     * @param admin 查询条件
     * @return 数量
     */
    int count(Admin admin);

    /**
     * 判断是否存在
     * @param admin 查询条件
     * @return 数量
     */
    int exists(Admin admin);

    /**
     * 登录
     * @param admin
     * @return
     */
    Admin login(Admin admin);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param adminid 主键
     * @return 影响行数
     */
    int deleteById(Integer adminid);

}