package com.itheima.service.impl;

import com.itheima.dao.CategoryDao;
import com.itheima.dao.RouteDao;
import com.itheima.domain.Route;
import com.itheima.service.IRouteService;
import com.itheima.utils.MyBatisUtil;
import com.itheima.utils.PageBean;

import java.util.List;

/**
 * @author wangxin
 * @date 2019/12/1 12:09
 * @description: TODO
 * GOOD LUCK！
 * 路线service接口实现类
 */
public class RouteServiceImpl implements IRouteService {
    RouteDao routeDao = MyBatisUtil.openSession().getMapper(RouteDao.class);
    CategoryDao categoryDao = MyBatisUtil.openSession().getMapper(CategoryDao.class);

    @Override
    public PageBean<Route> findRouteByPage(Integer cid, Integer currentPage, Integer pageSize, String rname) {
        //封装pageBean
        //查询总记录数
        int totalCount = routeDao.findCount(cid,rname);
        int totalPage = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);
        //计算startIndex
        int startIndex = (currentPage - 1) * pageSize;
        //查询分页数据
        List<Route> list = routeDao.findRouteByPage(cid, startIndex, pageSize, rname);
        //封装pageBean 方便返回
        PageBean<Route> pageBean = new PageBean<>();
        pageBean.setTotalCount(totalCount);
        pageBean.setCurrentPage(currentPage);
        pageBean.setList(list);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalPage(totalPage);
        System.out.println("pageBean = " + pageBean);
        return pageBean;
    }

    @Override
    public String findCnameByCid(Integer cid) {
        return categoryDao.findCnameByCid(cid);
    }
}
