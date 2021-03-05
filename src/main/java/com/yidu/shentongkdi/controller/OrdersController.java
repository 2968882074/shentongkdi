package com.yidu.shentongkdi.controller;

import com.google.gson.internal.$Gson$Preconditions;
import com.yidu.shentongkdi.entity.Orders;
import com.yidu.shentongkdi.service.OrdersService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * (Orders)表控制层
 *
 * @author makejava
 * @since 2020-12-28 14:56:39
 */
@RestController
@RequestMapping("orders")
public class OrdersController {
    /**
     * 服务对象
     */
    @Resource
    private OrdersService ordersService;

    /**
     * 模糊查询以及分页查询
     * @param page 页数
     * @param limit 行数
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("selectLimit")
    public Map<String,Object> selectLimit(int page, int  limit, Orders orders){
        System.out.println("page = " + page + ", limit = " + limit + ", orders = " + orders);
        List<Orders> orderList = ordersService.queryAllByLimit(page, limit, orders);
        //创建一个map集合对象
        Map<String,Object> map=new HashMap<>();
        map.put("code", 0);
        map.put("mag", "");
        //调用接口类的统计方法
        map.put("count",ordersService.count(orders));
        //调用接口类的分页查询以及模糊查询的方法
        map.put("data",orderList);
        //返回map集合
        return map;
    }

    /**
     * 根据id修改
     * @param orders 实体类
     * @return  成功返回真
     */
    @ResponseBody
    @RequestMapping("updateById")
    public Map<String, Object> updateById(Orders orders){
        Map<String,Object> map=new HashMap<>();
        //调用实现接口类的新增方法
        map.put("data",ordersService.update(orders)!=null?"修改成功":"修改失败");
        System.out.println("data="+map.get("data"));
        //返回map
        return map;
    }

    /**
     * 新增
     * @param orders 实体类
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("insert")
    public Map<String,Object> insert(Orders orders){
        Map<String,Object> map=new HashMap<>();
        //调用实现接口类的新增方法
        map.put("data",ordersService.insert(orders)!=null?"新增成功":"新增失败");
        System.out.println("data="+map.get("data"));
        //返回map
        return map;
    }

    /**
     * 删除
     * @param id 主键id
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("delete")
    public Map<String,Object> delete(int id){
        Map<String,Object> map=new HashMap<>();
        //调用接口类的删除方法
        map.put("data",ordersService.deleteById(id)>0?"删除成功":"删除失败");
        //返回map
        return map;
    }

    /**
     * 删除
     * @param id 主键id
     * @return 成功返回真
     */
    @ResponseBody
    @RequestMapping("deleteByIds")
    public Map<String,Object> deleteByIds(String id){
        String[] ids=id.split(",");
        for (String s:ids) {
            System.out.println(s+"-------"+id);

        }
        //调用接口类的删除方法
        Map<String,Object> map=new HashMap<>();
        //调用实现接口类的新增方法
        map.put("data",ordersService.deleteByIds(ids)>0?"删除成功":"删除失败");
        System.out.println("data="+map.get("data"));
        //返回map
        return map;
    }

    /**
     *  前端的查询
     * @param state 订单状态
     * @return
     */
    @RequestMapping("selectByState")
    public ModelAndView selectById(Integer state,HttpServletRequest request){
        List<Orders> list=ordersService.selectByUidAndState(1,null);
        ModelAndView mav=new ModelAndView("../jsp/OrderGL.jsp");
        request.getSession().setAttribute("orderList",list);
        return mav;
    }

@RequestMapping("SwitchState")
    public List<Orders> SwitchState(Integer state,HttpServletRequest request){
    List<Orders> list=ordersService.selectByUidAndState(1,state);
    request.getSession().setAttribute("orderList",list);
    return list;
    }
    @RequestMapping("detail")
    public ModelAndView Detail(Integer oid,HttpServletRequest request){
        ModelAndView mav=new ModelAndView("../jsp/OrderDetail.jsp");
        HttpSession session = request.getSession();
        List<Orders> orderList = (List<Orders>)session.getAttribute("orderList");
        for (Orders o : orderList){
            if(oid==o.getOid()){
                request.setAttribute("orderDetail",o);
            }
        }
        return mav;
    }
    //订单状态  ： 处理中=待取件   _> 已取件=运输中 -> 待签收-> 已完成
    //订单状态  ： 处理中=待取件   -> 已取消
}