package com.go8.admin.goods.controller;

import com.go8.admin.common.service.ServiceResponse;
import com.go8.admin.goods.vo.CatalogTreeVO;
import com.go8.admin.goods.vo.CatalogVO;
import com.go8.goods.pojo.Catalog;
import com.go8.goods.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("adminCatalogController")
@RequestMapping("/admin")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @PostMapping("catalogs")
    public Object add(@RequestBody Catalog catalog){
        try {
            catalogService.add(catalog);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ServiceResponse.error();
        }
    }

    @PutMapping("catalogs/{id}")
    public Object update(@PathVariable Long id,@RequestBody Catalog catalog){
        try {
            catalog.setId(id);
            catalogService.updateById(catalog);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ServiceResponse.error();
        }
    }

    @DeleteMapping("/catalogs/{id}")
    public Object delete(@PathVariable Long id){
        try {
            catalogService.delete(id);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ServiceResponse.error();
        }
    }

    @GetMapping("catalogs/code")
    public Object getCodeByCode(String code){
        if(StringUtils.isEmpty(code)){
            return ServiceResponse.illegalArgs();
        }
        try {
            code = catalogService.getCode(code);
            return ServiceResponse.ok(code);
        } catch (Exception e) {
            e.printStackTrace();
            return ServiceResponse.error();
        }
    }

    @GetMapping("catalogs/{id}")
    public Object getCatalogById(@PathVariable Long id){
        if(id==null || id.longValue()<0){
            return ServiceResponse.illegalArgs();
        }
        try {
            Catalog catalog = catalogService.getCatalogById(id);
            return ServiceResponse.ok(toCatalogVO(catalog));
        } catch (Exception e) {
            e.printStackTrace();
            return ServiceResponse.error();
        }
    }

    @GetMapping("catalogs/sons")
    public Object getCatalogByPid(Long pid){
        if(pid==null || pid.longValue()<0){
            return ServiceResponse.illegalArgs();
        }
        try {
            List<Catalog> list = catalogService.getSonsByPid(pid);
            List<CatalogTreeVO> vos = new ArrayList<>();
            for (Catalog cat:list){
                CatalogTreeVO vo = toCatalogTreeVO(cat);
                vos.add(vo);
            }
            return ServiceResponse.ok(vos);
        } catch (Exception e) {
            e.printStackTrace();
            return ServiceResponse.error();
        }
    }

    private CatalogTreeVO toCatalogTreeVO(Catalog cat) {
        CatalogTreeVO vo = new CatalogTreeVO();
        vo.setId(cat.getId());
        vo.setPid(cat.getPid());
        vo.setTitle(cat.getName());
        vo.setParent(cat.getParent());
        return vo;
    }

    private CatalogVO toCatalogVO(Catalog cat) {
        CatalogVO vo = new CatalogVO();
        vo.setId(cat.getId());
        vo.setPid(cat.getPid());
        vo.setName(cat.getName());
        vo.setCode(cat.getCode());
        vo.setParent(cat.getParent());
        vo.setOrder1(cat.getOrder1());
        return vo;
    }
}
