package com.yidu.shentongkdi.dao;

import com.yidu.shentongkdi.entity.Menuinfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Menuinfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-29 16:16:03
 */
public interface MenuinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param menuid 主键
     * @return 实例对象
     */
    Menuinfo queryById(String menuid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param menuinfo 查询条件
     * @return 对象列表
     */
    List<Menuinfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,Menuinfo menuinfo);

    /**
     * 得到数量可根据条件
     * @param menuinfo 查询条件
     * @return 数量
     */
    int count(Menuinfo menuinfo);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param menuinfo 实例对象
     * @return 对象列表
     */
    List<Menuinfo> queryAll(Menuinfo menuinfo);

    /**
     * 新增数据
     *
     * @param menuinfo 实例对象
     * @return 影响行数
     */
    int insert(Menuinfo menuinfo);

    /**
     * 修改数据
     *
     * @param menuinfo 实例对象
     * @return 影响行数
     */
    int update(Menuinfo menuinfo);

    /**
     * 通过主键删除数据
     *
     * @param menuid 主键
     * @return 影响行数
     */
    int deleteById(String menuid);

}