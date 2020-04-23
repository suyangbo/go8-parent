package com.go8.goods.service;

import com.go8.goods.mapper.CatalogMapper;
import com.go8.goods.pojo.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService{

    @Autowired
    private CatalogMapper catalogMapper;

    @Override
    public void add(Catalog catalog) {
        Catalog parent = catalogMapper.selectByPrimaryKey(catalog.getPid());
        if (parent !=null && !parent.getParent()){
            parent.setGmtModified(new Date());
            parent.setParent(true);
            catalogMapper.updateByPrimaryKeySelective(parent);
        }
        Date now = new Date();
        catalog.setGmtCreate(now);
        catalog.setGmtModified(now);
        catalogMapper.insert(catalog);
    }

    @Override
    public void updateById(Catalog catalog) {
        catalog.setGmtModified(new Date());
        catalogMapper.updateByPrimaryKeySelective(catalog);
    }

    @Override
    public void delete(Long id) {
        Catalog catalog = catalogMapper.selectByPrimaryKey(id);
        if (catalog!=null && catalog.getParent()){
            deleteSonsByPid(id);
        }
        catalogMapper.deleteByPrimaryKey(id);
        if(catalog!=null){
            Long pid = catalog.getPid();
            List<Catalog> list = catalogMapper.selectSonsByPid(pid);
            if(list==null || list.size()==0){
                Catalog parent = new Catalog();
                parent.setId(pid);
                parent.setParent(false);
                parent.setGmtModified(new Date());
                catalogMapper.updateByPrimaryKeySelective(parent);
            }
        }
    }

    private void deleteSonsByPid(Long pid) {
        List<Catalog> sons = catalogMapper.selectSonsByPid(pid);
        if (sons!=null){
            for (Catalog cat:sons){
                if(cat.getParent()){
                    deleteSonsByPid(cat.getId());
                    catalogMapper.deleteByPrimaryKey(cat.getId());
                }else{
                    catalogMapper.deleteByPrimaryKey(cat.getId());
                }
            }
        }
    }

    @Override
    public String getCode(String code) {
        return catalogMapper.selectCodeByCode(code);
    }

    @Override
    public Catalog getCatalogById(Long id) {
        return catalogMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Catalog> getSonsByPid(Long pid) {
        return catalogMapper.selectSonsByPid(pid);
    }

    @Override
    public List<Catalog> getAllChildrenByPid(Long pid) {
        //先获取第一节
        List<Catalog> list = catalogMapper.selectSonsByPid(pid);
        for(Catalog cat : list) {
            //如果是父节点继续查子节点
            if(cat.getParent()) {
                List<Catalog> sons = getAllChildrenByPid(cat.getId());
                cat.setChildren(sons);
            }
        }
        return list;
    }

}
