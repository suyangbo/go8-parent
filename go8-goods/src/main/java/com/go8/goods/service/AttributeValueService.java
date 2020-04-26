package com.go8.goods.service;

import com.go8.goods.pojo.AttributeValue;

import java.util.List;

public interface AttributeValueService {

    List<AttributeValue> getValuesByAttrId(Long aid);

    void addValue(AttributeValue value);
}
