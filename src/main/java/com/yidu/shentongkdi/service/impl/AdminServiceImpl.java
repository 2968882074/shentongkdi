package com.yidu.shentongkdi.service.impl;


import com.yidu.shentongkdi.dao.AdminDao;
import com.yidu.shentongkdi.dao.AdminroleDao;
import com.yidu.shentongkdi.dao.RoleinfoDao;
import com.yidu.shentongkdi.entity.*;
import com.yidu.shentongkdi.service.AdminService;
import com.yidu.shentongkdi.service.MenuinfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Resource
    private AdminroleDao adminroleDao;
    @Resource
    private RoleinfoDao roleinfoDao;

    @Resource
    private MenuinfoService menuinfoService;


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
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param admin 员工实体
     * @return 对象列表
     */
    @Override
    public List<Admin> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit, Admin admin){
        //接收查询的员工
        List<Admin> admins = this.adminDao.queryAllByLimit(offset, limit, admin);
        //实例员工角色对象
        Adminrole adminrole = new Adminrole();
        //遍历员工列表
        for (Admin admin1 : admins) {
            //设置员工id
            adminrole.setAdminid(admin1.getAdminid());
            //查询员工角色连接数据
            List<Adminrole> adminroles = adminroleDao.queryAll(adminrole);
            //创建角色列表
            List<Roleinfo> roleinfos = new ArrayList<>();
            //遍历员工角色列表
            for (Adminrole adminrole1 : adminroles) {
                //根据员工id,查询角色,并存入角色列表
                roleinfos.add(roleinfoDao.queryById(adminrole1.getRoleid()));
            }
            //将角色列表存入员工的角色
            admin1.setRolelist(roleinfos);
        }
        return admins;
    }

    @Override
    public int count(Admin admin) {
        return this.adminDao.count(admin);
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

        //接收Hashset的结果
        List<Menuinfo> menuinfoList = new ArrayList<>();
        //遍历menuset
        for(Menuinfo menuinfo:menuset){
            //添加到list
            menuinfoList.add(menuinfo);
        }


        //返回权限列表
        return menuinfoService.marge(menuinfoList);
    }




    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin insert(Admin admin,String roleid) {
        //实例角色对象
        Admin admin1 = new Admin();
        //设置员工名称
        admin1.setAdminname(admin.getAdminname());
        //判断员工是否存在
        if(adminDao.exists(admin1) == 0){
            //新增员工
            int insert = this.adminDao.insert(admin);
            //判断影响数据大于0
            if(insert > 0){
                //分割字符串
                String roleidlist[] = roleid.split(",");
                //创建Adminrole对象 接收参数
                Adminrole adminRole = new Adminrole();
                //设置员工id
                adminRole.setAdminid(admin.getAdminid());
                //遍历角色id
                for (String s : roleidlist) {
                    //设置角色id
                    adminRole.setRoleid(Integer.parseInt(s));
                    int exists = adminroleDao.exists(adminRole);
                    //判断不存在此数据时
                    if(exists==0){
                        //新增数据
                        int ints=adminroleDao.insert(adminRole);
                    }
                }
                return admin;
            }

        }
        return null;
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