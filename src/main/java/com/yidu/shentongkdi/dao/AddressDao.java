package com.yidu.shentongkdi.dao;

import com.yidu.shentongkdi.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Address)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-07 14:00:17
 */
@Mapper
@Repository
public interface AddressDao {
    /**
     * 通过ID查询单条数据
     *
     * @param aid 主键
     * @return 实例对象
     */
    Address queryById(Integer aid);

    /**
     * 统计
     * @return
     */
    int count();
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Address> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,String aname);
    /**
     * 通过实体作为筛选条件查询
     *
     * @param address 实例对象
     * @return 对象列表
     */
    List<Address> queryAll(Address address);
    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 影响行数
     */
    int insert(Address address);
    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 影响行数
     */
    int update(Address address);
    /**
     * 通过主键删除数据
     *
     * @param aid 主键
     * @return 影响行数
     */
    int deleteById(Integer aid);



    /**
     * 根据用户id查询页面数据
     * @param userid
     * @return
     */
    List<Address> queryAlladdress(Integer userid);
    /**
     * 新增页面数据
     * @param address 实列对象
     * @return 影响行数
     */
    int add(Address address);
    /**
     * 根据id删除页面数据
     * @param aid 主键
     * @return 影响行数
     */
    int deleteAddress(Integer aid,Integer userid);
    /**
     * 根据名称模糊查询页面数据
     * @param aname
     * @return
     */
    List<Address> queryAllaname(String aname);
    /**
     * 根据电话号码模糊查询页面数据
     * @param phone
     * @return
     */
    List<Address> queryAllphone(String phone);
}