package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Branch;
import com.yidu.shentongkdi.service.BranchService;
import net.sf.json.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 网点信息表控制层
 *
 * @author makejava
 * @since 2020-12-28 14:53:14
 */
@Controller
@RequestMapping
public class BranchController {
    /**
     * 服务对象
     */
    @Resource
    private BranchService branchService;

    /**
     *分页查询以及模糊查询
     * @param offset 页数
     * @param limit 行数
     * @param branchName 网点名称
     * @return 成功返回true
     */
    @RequestMapping("select")
    @ResponseBody
    public Map<String,Object> select(int offset, int limit, String branchName) {
        //创建map集合
        Map<String,Object> map=new HashMap<>();
        //把code设置为设置为0
        map.put("code",0);
        //把msg设置两个双引号
        map.put("msg","");
        //把统计数新增到map集合
        map.put("count",branchService.count());
        //把分页查询和网点名字新增到map集合
        map.put("data",branchService.queryAllByLimit((offset-limit)*limit,limit,branchName));
        //返回map集合
        return map;
    }
    /**
     * 网点信息的新增
     * @param json 转成json数据
     * @return 成功返回true
     */
    @RequestMapping("insert")
    @ResponseBody
    public boolean insert(String json) {
        //转成json数据
        JSONObject jsonObject=JSONObject.fromObject(json);
        //将网点信息的实体类装进json
        Branch branch=(Branch) JSONObject.toBean(jsonObject,Branch.class);
        //调用网点信息Service类的新增方法
           branchService.insert(branch);
        //返回真
        return true;
    }

    /**
     *网点信息的删除
     * @param brid 网点id
     * @return 删除成功返回true
     */
    @RequestMapping("delete")
    @ResponseBody
    public boolean delete(Integer brid) {
        //调用网点信息Service类的删除方法
     boolean i= branchService.deleteById(brid);
        return i;
    }
    /**
     * 网点信息的修改
     * @param json 转成json数据
     * @return修改成功返回true
     */
    @RequestMapping("update")
    @ResponseBody
    public boolean update(String json) {
        //转成json数据
        JSONObject jsonObject=JSONObject.fromObject(json);
        //将网点信息的实体类装进json
        Branch branch =(Branch) JSONObject.toBean(jsonObject, Branch.class);
        //调用网点信息Service类的新增方法
        branchService.update(branch);
        //返回真
        return true;

    }
}