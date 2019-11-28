package com.itheima.dao;

import com.itheima.domain.Address;

import java.util.List;

/**
 * @author wangxin
 * @date 2019/11/28 19:37
 * @description: TODO
 * GOOD LUCK！
 */
public interface AddressDao {

    /**
     * 查询用户id的地址list
     *
     * @param uid
     * @return
     */
    List<Address> findByUid(int uid);

    void save(Address address);
}
