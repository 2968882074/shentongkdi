package com.yidu.shentongkdi.service;

import com.yidu.shentongkdi.entity.Branch;

import java.util.List;

/**
 * (Branch)网点信息表表服务接口
 *
 * @author makejava
 * @since 2021-01-05 09:56:35
 */
public interface BranchService {

    /**
     * 通过ID查询单条数据
     *
     * @param brid 主键
     * @return 实例对象
     */
    Branch queryById(Integer brid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Branch> queryAllByLimit(int offset, int limit, String branchName);

    /**
     * 新增数据
     *
     * @param branch 实例对象
     * @return 实例对象
     */
    Branch insert(Branch branch);

    /**
     * 修改数据
     *
     * @param branch 实例对象
     * @return 实例对象
     */
    Branch update(Branch branch);

    /**
     * 通过主键删除数据
     *
     * @param brid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer brid);

    /**
     * 统计
     * @return
     */
   int count();
}