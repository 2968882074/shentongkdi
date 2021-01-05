package com.yidu.shentongkdi.service.impl;

import com.yidu.shentongkdi.entity.User;
import com.yidu.shentongkdi.dao.UserDao;
import com.yidu.shentongkdi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * (用户)表服务实现类
 *
 * @author makejava
 * @since 2020-12-28 13:45:32
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 统计行数
     * @return 实例对象
     */
    @Override
    public int count() {
        return  this.userDao.count();
    }

    @Override
    public User denglu(User user) {
        return this.userDao.denglu(user);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer userid) {
        return this.userDao.queryById(userid);
    }

    /**
     * 查询多条数据
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param username
     * @return
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit, String username) {
        return userDao.queryAllByLimit(offset,limit,username);
    }


    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User add(User user) {
        userDao.add(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUserid());
    }

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userid) {
        return this.userDao.deleteById(userid) > 0;
    }
}