package com.yidu.shentongkdi.dao;

import com.yidu.shentongkdi.entity.Courier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * (Courier)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-08 13:58:38
 */
@Controller
@Mapper

public interface CourierDao {
    Courier queryById(Integer courid);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Courier> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("couName") String couname);

    /**
     * 统计数量
     */
    int count();

    /**
     * 新增数据
     *
     * @param courier 实例对象
     * @return 影响行数
     */
    int insert(Courier courier);

    /**
     * 修改数据
     *
     * @param courier 实例对象
     * @return 影响行数
     */
    int update(Courier courier);

    /**
     * 通过主键删除数据
     *
     * @param courid 主键
     * @return 影响行数
     */
    int deleteById(Integer courid);


}