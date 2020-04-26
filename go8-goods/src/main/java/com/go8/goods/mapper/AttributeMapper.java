package com.go8.goods.mapper;

import com.go8.goods.pojo.Attribute;

import java.util.List;

public interface AttributeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Attribute record);

    int insertSelective(Attribute record);

    Attribute selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Attribute record);

    int updateByPrimaryKey(Attribute record);

    List<Attribute> selectAttributeAndValue(Attribute attr);
}