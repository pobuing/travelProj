package com.itheima.service.impl;

import com.itheima.dao.CategoryDao;
import com.itheima.domain.Category;
import com.itheima.service.ICategoryService;
import com.itheima.utils.MyBatisUtil;

import java.util.List;

/**
 * @author wangxin
 * @date 2019/11/30 12:20
 * @description: TODO
 * GOOD LUCK！
 */
public class CategoryServiceImpl implements ICategoryService {
    CategoryDao categoryDao = MyBatisUtil.openSession().getMapper(CategoryDao.class);

    @Override
    public List<Category> findAllCategory() {
        return categoryDao.findAllCategory();
    }
}
