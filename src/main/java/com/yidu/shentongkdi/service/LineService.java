package com.yidu.shentongkdi.service;

import com.yidu.shentongkdi.entity.Line;
import java.util.List;

/**
 * (Line)表服务接口
 *
 * @author makejava
 * @since 2020-12-27 12:10:38
 */
public interface LineService {

    /**
     * 通过ID查询单条数据
     *
     * @param lid 主键
     * @return 实例对象
     */
    Line queryById(Integer lid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Line> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param line 实例对象
     * @return 实例对象
     */
    Line insert(Line line);

    /**
     * 修改数据
     *
     * @param line 实例对象
     * @return 实例对象
     */
    Line update(Line line);

    /**
     * 通过主键删除数据
     *
     * @param lid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer lid);

}