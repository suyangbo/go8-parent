package com.go8.mall.controller;

import com.go8.admin.common.service.ServiceResponse;
import com.go8.goods.pojo.Catalog;
import com.go8.goods.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@CrossOrigin*/
@RestController
public class CatalogController {
	@Autowired
	private CatalogService catalogService;
	
	@PostMapping("catalogs")
	public Object add(Catalog catalog) {
		try {
			catalogService.add(catalog);
			return ServiceResponse.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceResponse.error();
		}
	}
	
	@PutMapping("catalogs/{id}")
	public Object update(Catalog catalog) {
		try {
			catalogService.add(catalog);
			return ServiceResponse.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceResponse.error();
		}
	}
	
	@GetMapping("catalogs/{id}")
	public Object getCatalogById(@PathVariable Long id) {
		if(id==null || id.longValue()<0) {
			return ServiceResponse.illegalArgs();
		}
		try {
			Catalog catalog = catalogService.getCatalogById(id);
			return ServiceResponse.ok(catalog);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceResponse.error();
		}
	}
	
	
	@GetMapping("catalogs/all")
	public Object getAllCatalogsByPid(Long pid) {
		if(pid==null || pid.longValue()<0) {
			return ServiceResponse.illegalArgs();
		}
		try {
			List<Catalog> list = catalogService.getAllChildrenByPid(pid);
			return ServiceResponse.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceResponse.error();
		}
	}
}
