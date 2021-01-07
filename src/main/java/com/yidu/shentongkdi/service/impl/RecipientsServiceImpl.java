package com.yidu.shentongkdi.service.impl;

import com.yidu.shentongkdi.dao.RecipientsDao;
import com.yidu.shentongkdi.entity.Recipients;
import com.yidu.shentongkdi.service.RecipientsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Recipients)表服务实现类
 *
 * @author makejava
 * @since 2021-01-07 09:45:46
 */
@Service("recipientsService")
public class RecipientsServiceImpl implements RecipientsService {
    @Resource
    private RecipientsDao recipientsDao;
    /**
     *  查询所有数据
     * @param recipients 实例对象
     * @return 对象列表
     */
    @Override
    public List<Recipients> queryAll(Recipients recipients) {
        return recipientsDao.queryAll(recipients);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param reid 主键
     * @return 实例对象
     */
    @Override
    public Recipients queryById(Integer reid) {
        return this.recipientsDao.queryById(reid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Recipients> queryAllByLimit(int offset, int limit) {
        return this.recipientsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param recipients 实例对象
     * @return 实例对象
     */
    @Override
    public Recipients insert(Recipients recipients) {
        this.recipientsDao.insert(recipients);
        return recipients;
    }

    /**
     * 修改数据
     *
     * @param recipients 实例对象
     * @return 实例对象
     */
    @Override
    public Recipients update(Recipients recipients) {
        this.recipientsDao.update(recipients);
        return this.queryById(recipients.getReid());
    }

    /**
     * 通过主键删除数据
     *
     * @param reid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer reid) {
        return this.recipientsDao.deleteById(reid) > 0;
    }
}