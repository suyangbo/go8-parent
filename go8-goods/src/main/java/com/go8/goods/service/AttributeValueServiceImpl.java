package com.go8.goods.service;

import com.go8.goods.mapper.AttributeValueMapper;
import com.go8.goods.pojo.AttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AttributeValueServiceImpl implements AttributeValueService {

    @Autowired
    private AttributeValueMapper attributeValueMapper;

    @Override
    public List<AttributeValue> getValuesByAttrId(Long aid) {
        return attributeValueMapper.selectByAttrId(aid);
    }

    @Override
    public void addValue(AttributeValue attrValue) {
        Date now = new Date();
        attrValue.setGmtCreate(now);
        attrValue.setGmtModified(now);
        attributeValueMapper.insert(attrValue);
    }
}
