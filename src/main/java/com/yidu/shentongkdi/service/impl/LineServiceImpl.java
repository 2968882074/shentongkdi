package com.yidu.shentongkdi.service.impl;

import com.yidu.shentongkdi.entity.Line;
import com.yidu.shentongkdi.dao.LineDao;
import com.yidu.shentongkdi.service.LineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Line)表服务实现类
 *
 * @author makejava
 * @since 2020-12-27 12:10:39
 */
@Service("lineService")
public class LineServiceImpl implements LineService {
    @Resource
    private LineDao lineDao;

    /**
     * 通过ID查询单条数据
     *
     * @param lid 主键
     * @return 实例对象
     */
    @Override
    public Line queryById(Integer lid) {
        return this.lineDao.queryById(lid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Line> queryAllByLimit(int offset, int limit) {
        return this.lineDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param line 实例对象
     * @return 实例对象
     */
    @Override
    public Line insert(Line line) {
        this.lineDao.insert(line);
        return line;
    }

    /**
     * 修改数据
     *
     * @param line 实例对象
     * @return 实例对象
     */
    @Override
    public Line update(Line line) {
        this.lineDao.update(line);
        return this.queryById(line.getLid());
    }

    /**
     * 通过主键删除数据
     *
     * @param lid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer lid) {
        return this.lineDao.deleteById(lid) > 0;
    }
}