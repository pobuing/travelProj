package com.itheima.dao;

import com.itheima.domain.Route;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangxin
 * @date 2019/12/1 12:15
 * @description: TODO
 * GOOD LUCK！
 * 路线持久层dao
 */
public interface RouteDao {
    /**
     * 查询cid对应分类的route总数
     *
     * @param cid
     * @return
     */
    int findCount(@Param("cid") Integer cid,
                  @Param("rname") String rname);

    /**
     * 查询路线数据分页
     *
     * @param cid        分类
     * @param startIndex 起始索引
     * @param pageSize   每页显示多少个
     * @param rname
     */
    List<Route> findRouteByPage(@Param("cid") Integer cid,
                                @Param("startIndex") int startIndex,
                                @Param("pageSize") Integer pageSize,
                                @Param("rname") String rname);

    /**
     * 通过rin查询route详情
     * @param rid
     * @return
     */
    Route findRouteDetailByRid(Integer rid);
    Route findRouteByRid(Integer rid);
}
