package com.go8.goods.service;

import com.go8.admin.common.MysqlPageWrapper;
import com.go8.goods.mapper.BrandMapper;
import com.go8.goods.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> getBrandsByCondition(MysqlPageWrapper<Brand> condition) {
        return brandMapper.selectByCondition(condition);
    }

    @Override
    public Long getCountByCondition(Brand condition) {
        return brandMapper.selectCountByCondition(condition);
    }

    @Override
    public void add(Brand brand) {
        Date now = new Date();
        brand.setGmtModified(now);
        brand.setGmtCreate(now);
        brandMapper.insert(brand);
    }

    @Override
    public void updateById(Brand brand) {
        brand.setGmtModified(new Date());
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void deleteByIds(String ids) {
        String[] aid = ids.split(",");
        for (String sd : aid) {
            long id = Long.parseLong(sd);
            brandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public Brand getBrandById(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Brand> getBrandsByCid(Long cid) {
        return brandMapper.selectByCatalogId(cid);
    }

}
