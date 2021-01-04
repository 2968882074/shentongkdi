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
        //创建集合,存放过滤后权限
        HashSet<Menuinfo> menuset = new HashSet<>();

        //遍历用户的角色
        for (Roleinfo roleinfo : admin.getRolelist()) {
            //遍历角色的权限
            for (Menuinfo menuinfo : roleinfo.getMenulist()) {
                //添加到HashSet因为其本身的特性所以不需要判断是否重复
                menuset.add(menuinfo);
            }
        }

        //一级权限
        //创建权限列表,存放权限
        List<Menuinfo> menulist = new ArrayList<>();
        //遍历menuset,取出权限
        for (Menuinfo menuinfo : menuset) {
            //判断权限的上级为空,说明是一级权限
            if(menuinfo.getPrevid() == null){
                //添加到列表
                menulist.add(menuinfo);
            }
        }

        //把一级权限从menuset中删除
        menuset.removeAll(menulist);
        
        
        //遍历一级权限
        for (Menuinfo menuinfo : menulist) {
            //遍历权限列表
            for (Menuinfo menuinfo1 : menuset) {
                //判断一级权限ID为权限的父级ID
                if(menuinfo.getMenuid().equals(menuinfo1.getPrevid())){
                    //判断一级权限的子权限列表为空时,开辟空间
                    if(menuinfo.getMenulist() == null) menuinfo.setMenulist(new ArrayList<>());
                    //将权限添加到一级权限的子权限列表
                    menuinfo.getMenulist().add(menuinfo1);
                }
            }
        }


        //返回权限列表
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