package com.itheima.service;

import com.itheima.domain.Route;
import com.itheima.utils.PageBean;

/**
 * @author wangxin
 * @date 2019/12/1 12:08
 * @description: TODO
 * GOOD LUCK！
 * 路线service
 */
public interface IRouteService {


    PageBean<Route> findRouteByPage(Integer cid, Integer currentPage, Integer pageSize, String rname);

    String findCnameByCid(Integer cid);

    Route findRouteDetail(Integer rid);

    /**
     * 根据rid查询route
     *
     * @param rid
     * @return
     */
    Route findRouteByRid(String rid);
}
