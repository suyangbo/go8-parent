package com.go8.goods.mapper;

import com.go8.admin.common.MysqlPageWrapper;
import com.go8.goods.pojo.Product;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    long selectCount(Product p);

    List<Product> selectByPage(MysqlPageWrapper<Product> mpw);
}