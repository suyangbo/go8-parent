package com.go8.goods.service;

import com.go8.goods.mapper.AttributeMapper;
import com.go8.goods.pojo.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private AttributeMapper attributeMapper;

    @Override
    public List<Attribute> getAttrAndValue(Attribute attr) {
        return attributeMapper.selectAttributeAndValue(attr);
    }

    @Override
    public void addAttribute(Attribute attr) {
        Date now = new Date();
        attr.setGmtCreate(now);
        attr.setGmtModified(now);
        attributeMapper.insert(attr);
    }
}
