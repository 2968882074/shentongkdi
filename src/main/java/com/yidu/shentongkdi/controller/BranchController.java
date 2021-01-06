package com.yidu.shentongkdi.controller;

import com.yidu.shentongkdi.entity.Branch;
import com.yidu.shentongkdi.service.BranchService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * (Branch)网点信息表控制层
 *
 * @author makejava
 * @since 2020-12-28 14:53:14
 */
@Controller
@RequestMapping("branch")
public class BranchController {
    /**
     * 服务对象
     */
    @Autowired
    private BranchService branchService;
    /**
     *网点信息的分页查询以及模糊查询
     * @param page 页数
     * @param limit 行数
     * @param branchName 网点名称
     * @return 成功返回true
     */
    @RequestMapping("selectAll")
    @ResponseBody
    public Map<String,Object> select(int page, int limit, String branchName) {
        //创建map集合
        Map<String,Object> map=new HashMap<>();
        //把code设置为设置为0
        map.put("code",0);
        //把msg设置两个双引号
        map.put("msg","");
        //把统计数新增到map集合
        map.put("count",branchService.count());
        //把分页查询和网点名字新增到map集合
        map.put("data",branchService.queryAllByLimit((page-1)*limit,limit,branchName));
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
    public String delete(String  brid) {
        //调用网点信息Service类的删除方法
        String []ids=brid.split("-");
        //循环删除网点信息表的信息
        for (int j = 0; j <ids.length ; j++) {
            try {
                //调用网点信息Service类的删除方法
                branchService.deleteById(Integer.parseInt(ids[j]));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                //返回的数据转成json数据
                return "{\"state\":false}";
            }
        }
        //返回的真
        return "{\"state\":true}";
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