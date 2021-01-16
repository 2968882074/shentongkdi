package com.yidu.shentongkdi.dao;

import com.yidu.shentongkdi.entity.Admin;
import com.yidu.shentongkdi.entity.Adminrole;
import com.yidu.shentongkdi.entity.Roleinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Adminrole)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-12 10:48:23
 */
@Mapper
@Repository
public interface AdminroleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param adminrole 主键
     * @return 实例对象
     */
    Adminrole queryById(Integer adminrole);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Adminrole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param adminrole 实例对象
     * @return 对象列表
     */
    List<Adminrole> queryAll(Adminrole adminrole);

    /**
     * 判断是否存在
     * @param adminrole
     * @return
     */
    int exists(Adminrole adminrole);

    /**
     * 新增数据
     *
     * @param adminrole 实例对象
     * @return 影响行数
     */
    int insert(Adminrole adminrole);

    /**
     * 修改数据
     *
     * @param adminrole 实例对象
     * @return 影响行数
     */
    int update(Adminrole adminrole);

    /**
     * 通过主键删除数据
     *
     * @param adminrole 主键
     * @return 影响行数
     */
    int deleteById(Integer adminrole);

}