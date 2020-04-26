package com.go8.goods.service;

import com.go8.goods.pojo.Attribute;

import java.util.List;

public interface AttributeService {

    List<Attribute> getAttrAndValue(Attribute attr);

    void addAttribute(Attribute attr);
}
