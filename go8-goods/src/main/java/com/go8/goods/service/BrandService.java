package com.go8.goods.service;

import com.go8.admin.common.MysqlPageWrapper;
import com.go8.goods.pojo.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getBrandsByCondition(MysqlPageWrapper<Brand> condition);

    Long getCountByCondition(Brand condition);

    void add(Brand brand);

    void updateById(Brand brand);

    void deleteByIds(String ids);

    Brand getBrandById(Long id);

    List<Brand> getBrandsByCid(Long cid);
}
