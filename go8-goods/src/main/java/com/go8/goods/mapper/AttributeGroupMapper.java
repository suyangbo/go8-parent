package com.go8.goods.mapper;

import com.go8.goods.pojo.AttributeGroup;

public interface AttributeGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AttributeGroup record);

    int insertSelective(AttributeGroup record);

    AttributeGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AttributeGroup record);

    int updateByPrimaryKey(AttributeGroup record);
}