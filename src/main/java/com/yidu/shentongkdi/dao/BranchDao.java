package com.yidu.shentongkdi.dao;

import com.yidu.shentongkdi.entity.Branch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Branch)网点信息表数据库访问层
 *
 * @author makejava
 * @since 2021-01-06 08:56:17
 */
@Mapper
@Repository
public interface BranchDao {

    /**
     * 通过ID查询单条数据
     *
     * @param brid 主键
     * @return 实例对象
     */
    Branch queryById(Integer brid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Branch> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,String branchName);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param branch 实例对象
     * @return 对象列表
     */
    List<Branch> queryAll(Branch branch);

    /**
     * 新增数据
     *
     * @param branch 实例对象
     * @return 影响行数
     */
    int insert(Branch branch);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Branch> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Branch> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Branch> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Branch> entities);

    /**
     * 修改数据
     *
     * @param branch 实例对象
     * @return 影响行数
     */
    int update(Branch branch);

    /**
     * 通过主键删除数据
     *
     * @param brid 主键
     * @return 影响行数
     */
    int deleteById(Integer brid);

    /**
     * 统计
     * @return
     */
    int count ();

}