package com.yidu.shentongkdi.service.impl;

import com.yidu.shentongkdi.dao.BranchDao;
import com.yidu.shentongkdi.entity.Branch;
import com.yidu.shentongkdi.service.BranchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 网点信息表服务实现类
 *
 * @author makejava
 * @since 2020-12-28 14:53:14
 */
@Service("branchService")
public class BranchServiceImpl implements BranchService {
    @Resource
    private BranchDao branchDao;

    /**
     * 通过ID查询单条数据
     *
     * @param brid 主键
     * @return 实例对象
     */
    @Override
    public Branch queryById(Integer brid) {
        return this.branchDao.queryById(brid);
    }
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     *  @param branchName 查询网点名称
     * @return 对象列表
     */
    @Override
    public List<Branch> queryAllByLimit(int offset, int limit, String branchName) {
        return this.queryAllByLimit(offset,limit,branchName);
    }


    /**
     * 新增数据
     *
     * @param branch 实例对象
     * @return 实例对象
     */
    @Override
    public Branch insert(Branch branch) {
        this.branchDao.insert(branch);
        return branch;
    }

    /**
     * 修改数据
     *
     * @param branch 实例对象
     * @return 实例对象
     */
    @Override
    public Branch update(Branch branch) {
        this.branchDao.update(branch);
        return this.queryById(branch.getBrid());
    }

    /**
     * 删除网点信息
     * @param brid 主键 网点信息id
     * @return
     */
    @Override
    public boolean deleteById(Integer brid) {

        return this.branchDao.deleteById(brid) > 0;
    }

    @Override
    public int count() {
        return this.count();
    }
}