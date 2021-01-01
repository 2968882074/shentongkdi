package com.yidu.shentongkdi.service.impl;


import com.yidu.shentongkdi.dao.AdminDao;
import com.yidu.shentongkdi.entity.Admin;
import com.yidu.shentongkdi.entity.Menuinfo;
import com.yidu.shentongkdi.entity.Roleinfo;
import com.yidu.shentongkdi.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2020-12-13 17:56:19
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param adminid 主键
     * @return 实例对象
     */
    @Override
    public Admin queryById(Integer adminid) {
        return this.adminDao.queryById(adminid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Admin> queryAllByLimit(int offset, int limit) {
        return this.adminDao.queryAllByLimit(offset, limit);
    }

    @Override
    public Admin login(Admin admin) {
        return this.adminDao.login(admin);
    }

    @Override
    public List<Menuinfo> merge(Admin admin) {
        HashSet<Menuinfo> menuset = new HashSet<>();

        //遍历用户的角色
        for (Roleinfo roleinfo : admin.getRolelist()) {
            //遍历角色的权限
            for (Menuinfo menuinfo : roleinfo.getMenulist()) {
                //添加到HashSet因为其本身的特性所以不需要判断是否重复
                menuset.add(menuinfo);
            }
        }

        //二级权限
        List<Menuinfo> menulist = new ArrayList<>();
        for (Menuinfo menuinfo : menuset) {
            if(menuinfo.getPrevid() == null){
                menulist.add(menuinfo);
                menuset.remove(menuinfo);
                for (Menuinfo menuinfo1 : menuset) {
                    if(menuinfo1.getPrevid().equals(menuinfo.getMenuid())){
                        menuinfo.getMenulist().add(menuinfo1);
                    }
                }

            }
        }

        return menulist;
    }




    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin insert(Admin admin) {
        this.adminDao.insert(admin);
        return admin;
    }

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin update(Admin admin) {
        this.adminDao.update(admin);
        return this.queryById(admin.getAdminid());
    }

    /**
     * 通过主键删除数据
     *
     * @param adminid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer adminid) {
        return this.adminDao.deleteById(adminid) > 0;
    }
}