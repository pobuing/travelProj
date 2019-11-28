package com.itheima.service.impl;

import com.itheima.dao.AddressDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Address;
import com.itheima.service.IAddressService;
import com.itheima.utils.MyBatisUtil;

import java.util.List;

/**
 * @author wangxin
 * @date 2019/11/28 18:50
 * @description: TODO
 * GOOD LUCK！
 * 地址Service实现类
 */
public class AddressServiceImpl implements IAddressService {
    AddressDao addressDao = MyBatisUtil.openSession().getMapper(AddressDao.class);

    @Override
    public List<Address> findMyAddress(int uid) {
        return addressDao.findByUid(uid);
    }

    @Override
    public void save(Address address) {
        addressDao.save(address);
    }
}
