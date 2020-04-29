package com.go8.goods.service;

import com.go8.admin.common.MysqlPageWrapper;
import com.go8.goods.mapper.*;
import com.go8.goods.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductDetailMapper productDetailMapper;
    @Autowired
    private ProductSkuMapper productSkuMapper;
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private CatalogMapper catalogMapper;

    @Override
    public List<Product> getProducts(int page, int size, Product product) {
        MysqlPageWrapper<Product> mpw = new MysqlPageWrapper<>(page, size, product);
        return productMapper.selectByPage(mpw);
    }

    @Override
    public long getCount(Product p) {
        return productMapper.selectCount(p);
    }


    @Override
    public void updatePartial(Product p) {
        productMapper.updateByPrimaryKeySelective(p);
    }

}
