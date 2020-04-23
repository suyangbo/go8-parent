package com.go8.goods.mapper;

import com.go8.admin.common.MysqlPageWrapper;
import com.go8.goods.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    List<Brand> selectByCondition(MysqlPageWrapper<Brand> condition);

    Long selectCountByCondition(Brand condition);

    List<Brand> selectByCatalogId(Long cid);
}