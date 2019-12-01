package com.itheima.utils;

import lombok.Data;

import java.util.List;

/**
 * @author wangxin
 * @date 2019/12/1 11:56
 * @description: TODO
 * GOOD LUCK！
 * 分页pagebean
 */
@Data
public class PageBean<T> {
    //记录总数
    private int totalCount;
    //总页数
    private int totalPage;
    //数据
    private List<T> list;
    // 当前页面
    private int currentPage;
    //每页显示条数
    private int pageSize;
    //实现前三后四
    private int begin;
    private int end;

    public int getBegin() {
        jisuan();
        return begin;
    }

    private void jisuan() {
        if (totalPage <= 10) {
            begin = 1;
            end = totalPage;
        } else {
            begin = currentPage - 5;
            end = currentPage + 4;
            //修正
            if (begin < 0) {
                begin = 1;
                end = 10;
            }
            if (end>totalPage) {
                end = totalPage;
                begin = totalPage -9;
            }
        }
    }


}
