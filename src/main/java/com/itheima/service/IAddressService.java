package com.itheima.service;

import com.itheima.domain.Address;

import java.util.List;

/**
 * @author wangxin
 * @date 2019/11/28 18:49
 * @description: TODO
 * GOOD LUCK！
 */
public interface IAddressService {
    List<Address> findMyAddress(int uid);

    void save(Address address);

}
