package com.go8.admin.goods.controller;

import com.go8.admin.common.service.ServiceResponse;
import com.go8.goods.pojo.Attribute;
import com.go8.goods.pojo.AttributeValue;
import com.go8.goods.service.AttributeService;
import com.go8.goods.service.AttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("adminAttributeController")
@RequestMapping("/admin/attribute")
public class AttributeController {
    @Autowired
    private AttributeService attributeService;

    @Autowired
    private AttributeValueService attributeValueService;

    @PostMapping("/add")
    public Object add(@RequestBody Attribute attr) {
        try {
            attributeService.addAttribute(attr);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ServiceResponse.error();
        }
    }

    @GetMapping("/list")
    public Object getAttrAndValue(Attribute attr) {
        try {
            List<Attribute> list = attributeService.getAttrAndValue(attr);
            return ServiceResponse.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ServiceResponse.error();
        }
    }

    @PostMapping("/value/add")
    public Object addValue(@RequestBody AttributeValue value) {
        try {
            attributeValueService.addValue(value);
            return ServiceResponse.ok(value);
        } catch (Exception e) {
            e.printStackTrace();
            return ServiceResponse.error();
        }
    }

    @GetMapping("/value/list")
    public Object getAttrValue(Long aid) {
        try {
            List<AttributeValue> list = attributeValueService.getValuesByAttrId(aid);
            return ServiceResponse.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ServiceResponse.error();
        }
    }
}
