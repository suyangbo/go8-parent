package com.go8.admin.goods.controller;

import com.go8.admin.common.MysqlPageWrapper;
import com.go8.admin.common.service.ServiceResponse;
import com.go8.admin.goods.vo.BrandSelectVO;
import com.go8.admin.goods.vo.BrandVO;
import com.go8.goods.pojo.Brand;
import com.go8.goods.service.BrandService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("adminBrandController")
@RequestMapping("/admin")
public class BrandController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private BrandService brandService;

    @PostMapping("brands")
    public Object add(@RequestBody Brand brand) {
        logger.debug("params is  brand : {}", brand);
        try {
            brandService.add(brand);
            return ServiceResponse.ok();
        } catch (Exception e) {
            logger.error(brand + "_" + e.getMessage(), e);
            return ServiceResponse.error();
        }
    }

    @PutMapping("brands/{id}")
    public Object update(@PathVariable Long id, @RequestBody Brand brand) {
        try {
            brand.setId(id);
            brandService.updateById(brand);
            return ServiceResponse.ok();
        } catch (Exception e) {
            logger.error(brand + "_" + e.getMessage(), e);
            return ServiceResponse.error();
        }
    }

    @DeleteMapping("brands")
    public Object deletes(String ids) {
        logger.debug("params is  ids : {}", ids);
        String[] aids = ids.split(",");
        if (aids == null || aids.length == 0) {
            logger.error("bad ids:" + ids);
            return ServiceResponse.illegalArgs();
        }
        try {
            brandService.deleteByIds(ids);
            return ServiceResponse.ok();
        } catch (Exception e) {
            logger.error(ids + "_" + e.getMessage(), e);
            return ServiceResponse.error();
        }
    }

    @GetMapping("brands/{id}")
    public Object getBrandById(@PathVariable Long id) {
        logger.debug("params is id:{}", id);
        if (id <= 0) {
            logger.warn("params of brand is illegal. id : {}", id);
            return ServiceResponse.illegalArgs();
        }
        try {
            Brand brand = brandService.getBrandById(id);
            return ServiceResponse.ok(toBrandVO(brand));
        } catch (Exception e) {
            logger.error(id + "_" + e.getMessage(), e);
            return ServiceResponse.error();
        }
    }

    @GetMapping("brands")
    public Object getBrandsByCondition(int page, int size, Brand brand) {
        logger.debug("params is page:{},size:{},brand:{}", page, size, brand);
        if (page <= 0 || size <= 0) {
            logger.warn("params of brand is illegal. page : {}, size : {}", page, size);
            return ServiceResponse.illegalArgs();
        }
        try {
            MysqlPageWrapper<Brand> condition = new MysqlPageWrapper<>(page, size, brand);
            List<Brand> brands = brandService.getBrandsByCondition(condition);
            List<BrandVO> vos = new ArrayList<>();
            for (Brand b : brands) {
                vos.add(toBrandVO(b));
            }
            //查询总记录数
            Long total = brandService.getCountByCondition(brand);
            Map<String, Object> map = new HashMap<>();
            map.put("total", total);
            map.put("rows", vos);
            return ServiceResponse.ok(map);
        } catch (Exception e) {
            logger.error(brand + "_" + e.getMessage(), e);
            return ServiceResponse.error();
        }
    }

    @GetMapping("brands/select")
    public Object getBrandsByCid(Long cid) {
        logger.debug("params is  cid : {}", cid);
        if (cid <= 0) {
            logger.warn("params of brand is illegal. cid : {}", cid);
            return ServiceResponse.illegalArgs();
        }
        try {
            List<Brand> brands = brandService.getBrandsByCid(cid);
            List<BrandSelectVO> vos = new ArrayList<>();
            for (Brand b : brands) {
                vos.add(toSelectVO(b));
            }
            return ServiceResponse.ok(vos);
        } catch (Exception e) {
            logger.error(cid + "_" + e.getMessage(), e);
            return ServiceResponse.error();
        }
    }

    private BrandSelectVO toSelectVO(Brand brand) {
        BrandSelectVO vo = new BrandSelectVO();
        vo.setId(brand.getId());
        vo.setCname(brand.getCname());
        return vo;
    }

    private BrandVO toBrandVO(Brand brand) {
        BrandVO vo = new BrandVO();
        vo.setId(brand.getId());
        vo.setCatName(brand.getCatName());
        vo.setCid(brand.getCid());
        vo.setCname(brand.getCname());
        vo.setEname(brand.getEname());
        vo.setLogo(brand.getLogo());
        vo.setRemark(brand.getRemark());
        vo.setSource(brand.getSource());
        vo.setStatus(brand.getStatus());
        vo.setUrl(brand.getUrl());
        return vo;
    }
}
