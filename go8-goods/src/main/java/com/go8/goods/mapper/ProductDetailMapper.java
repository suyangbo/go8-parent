package com.go8.goods.mapper;

import com.go8.goods.pojo.ProductDetail;

public interface ProductDetailMapper {
    int deleteByPrimaryKey(Long productId);

    int insert(ProductDetail record);

    int insertSelective(ProductDetail record);

    ProductDetail selectByPrimaryKey(Long productId);

    int updateByPrimaryKeySelective(ProductDetail record);

    int updateByPrimaryKeyWithBLOBs(ProductDetail record);

    int updateByPrimaryKey(ProductDetail record);
}