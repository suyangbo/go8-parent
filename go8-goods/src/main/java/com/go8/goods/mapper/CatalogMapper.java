package com.go8.goods.mapper;

import com.go8.goods.pojo.Catalog;

import java.util.List;

public interface CatalogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Catalog record);

    int insertSelective(Catalog record);

    Catalog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Catalog record);

    int updateByPrimaryKey(Catalog record);

    String selectCodeByCode(String code);

    List<Catalog> selectSonsByPid(Long pid);
}