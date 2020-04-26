package com.go8.goods.mapper;

import com.go8.goods.pojo.AttributeValue;

import java.util.List;

public interface AttributeValueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AttributeValue record);

    int insertSelective(AttributeValue record);

    AttributeValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AttributeValue record);

    int updateByPrimaryKey(AttributeValue record);

    List<AttributeValue> selectByAttrId(Long aid);
}