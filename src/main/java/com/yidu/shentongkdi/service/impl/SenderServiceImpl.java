package com.yidu.shentongkdi.service.impl;

import com.yidu.shentongkdi.entity.Sender;
import com.yidu.shentongkdi.dao.SenderDao;
import com.yidu.shentongkdi.service.SenderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Sender)表服务实现类
 *
 * @author makejava
 * @since 2021-01-11 11:01:00
 */
@Service("senderService")
public class SenderServiceImpl implements SenderService {
    @Resource
    private SenderDao senderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param seid 主键
     * @return 实例对象
     */
    @Override
    public Sender queryById(Integer seid) {
        return this.senderDao.queryById(seid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Sender> queryAllByLimit(int offset, int limit) {
        return this.senderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sender 实例对象
     * @return 实例对象
     */
    @Override
    public Sender insert(Sender sender) {
        this.senderDao.insert(sender);
        return sender;
    }

    /**
     * 修改数据
     *
     * @param sender 实例对象
     * @return 实例对象
     */
    @Override
    public Sender update(Sender sender) {
        this.senderDao.update(sender);
        return this.queryById(sender.getSeid());
    }

    /**
     * 通过主键删除数据
     *
     * @param seid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer seid) {
        return this.senderDao.deleteById(seid) > 0;
    }


    public List<Sender> queryAll(){
        return this.senderDao.queryAll();
    }

    @Override
    public int selectCount() {
        return this.senderDao.selectCount();
    }
}