package com.yidu.shentongkdi.service.impl;

import com.yidu.shentongkdi.dao.MenuinfoDao;
import com.yidu.shentongkdi.dao.RolemenuDao;
import com.yidu.shentongkdi.entity.Menuinfo;
import com.yidu.shentongkdi.entity.Roleinfo;
import com.yidu.shentongkdi.dao.RoleinfoDao;
import com.yidu.shentongkdi.entity.Rolemenu;
import com.yidu.shentongkdi.service.RoleinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

/**
 * (Roleinfo)表服务实现类
 *
 * @author makejava
 * @since 2021-01-07 10:20:38
 */
@Service("roleinfoService")
public class RoleinfoServiceImpl implements RoleinfoService {
    @Resource
    private RoleinfoDao roleinfoDao;
    @Resource
    private RolemenuDao rolemenuDao;
    @Resource
    private MenuinfoDao menuinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roleid 主键
     * @return 实例对象
     */
    @Override
    public Roleinfo queryById(Integer roleid) {
        return this.roleinfoDao.queryById(roleid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Roleinfo> queryAllByLimit(int offset, int limit,Roleinfo roleinfo) {
        //接收查询的角色
        List<Roleinfo> roleinfos = this.roleinfoDao.queryAllByLimit(offset, limit, roleinfo);
        //实例角色权限对象
        Rolemenu rolemenu = new Rolemenu();
        for (Roleinfo roleinfo1 : roleinfos) {
            //设置角色id
            rolemenu.setRoleid(roleinfo1.getRoleid());
            //查询角色权限连接数据
            List<Rolemenu> rolemenus = rolemenuDao.queryAll(rolemenu);
            //查询权限列表
            List<Menuinfo> menuinfoList = new ArrayList<>();
            //遍历角色权限列表
            for (Rolemenu rolemenu1 : rolemenus) {
                //根据权限id,查询权限,并存入权限列表
                menuinfoList.add(menuinfoDao.queryById(rolemenu1.getMenuid()));
            }
            //将权限列表存入角色的权限列表对象
            roleinfo1.setMenulist(menuinfoList);
        }
        return roleinfos;
    }

    @Override
    public int count(Roleinfo roleinfo) {
        return this.roleinfoDao.count(roleinfo);
    }

    @Override
    public List<Roleinfo> queryAll(Roleinfo roleinfo) {
        return this.roleinfoDao.queryAll(roleinfo);
    }

    /**
     * 新增数据
     *
     * @param roleinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Roleinfo insert(Roleinfo roleinfo,String menuid) {
        //实例角色对象
        Roleinfo roleinfo1 = new Roleinfo();
        //设置角色名称
        roleinfo1.setRolename(roleinfo.getRolename());
        //判断角色是否存在
        if(roleinfoDao.count(roleinfo1) == 0){
            //新增角色
            int insert = roleinfoDao.insert(roleinfo);
            //判断影响数据大于0
            if(insert > 0){
                //分割字符串
                String menulist[] = menuid.split(",");
                //创建RoleMenu对象 接收参数
                Rolemenu rolemenu = new Rolemenu();
                //设置角色id
                rolemenu.setRoleid(roleinfo.getRoleid());
                //遍历权限id
                for (String s : menulist) {
                    //设置权限id
                    rolemenu.setMenuid(s);
                    //判断角色权限数据是否存在
                    int exists =rolemenuDao.exists(rolemenu);
                    //判断不存在此数据时
                    if(exists==0){
                        //新增数据
                        int ints=rolemenuDao.insert(rolemenu);
                    }
                }

                return roleinfo;
            }

        }
        return null;
    }

    /**
     * 修改数据
     *
     * @param roleinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Roleinfo update(Roleinfo roleinfo,String menuid) {
        //实例角色对象
        Roleinfo roleinfo1 = new Roleinfo();
        //设置角色名称
        roleinfo1.setRolename(roleinfo.getRolename());
        //新增角色
        int insert = roleinfoDao.update(roleinfo);
        //判断影响数据大于0
        if (insert > 0) {
            //删除角色权限
            rolemenuDao.deleteByRoleid(roleinfo.getRoleid());
            //分割字符串
            String menulist[] = menuid.split(",");
            //创建RoleMenu对象 接收参数
            Rolemenu rolemenu = new Rolemenu();
            //设置角色id
            rolemenu.setRoleid(roleinfo.getRoleid());
            //遍历权限id
            for (String s : menulist) {
                System.out.println(s);
                //设置权限id
                rolemenu.setMenuid(s);
                //新增数据
                int ints = rolemenuDao.insert(rolemenu);
            }


        }

        return roleinfo;
    }
    /**
     * 通过主键删除数据
     *
     * @param roleid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String roleid) {
        //删除角色
        int i = roleinfoDao.deleteById(roleid);
        if(i > 0){
            //分割字符串
            String roleids[]= roleid.split(",");
            //遍历角色id数组
            for (String s : roleids) {
                //删除权限关联
                rolemenuDao.deleteByRoleid(Integer.parseInt(s));
            }
        }

        return i > 0;
    }
}