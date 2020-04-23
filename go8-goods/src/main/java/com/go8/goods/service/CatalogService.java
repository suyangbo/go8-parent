package com.go8.goods.service;

import com.go8.goods.pojo.Catalog;
import java.util.List;

public interface CatalogService {

    String getCode(String code);

    Catalog getCatalogById(Long id);

    List<Catalog> getSonsByPid(Long pid);

    List<Catalog> getAllChildrenByPid(Long pid);

    void add(Catalog catalog);

    void update(Catalog catalog);

    void delete(Long id);
}
