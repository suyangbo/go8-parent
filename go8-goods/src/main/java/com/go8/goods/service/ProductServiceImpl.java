package com.go8.goods.service;

import com.go8.admin.common.MysqlPageWrapper;
import com.go8.goods.mapper.*;
import com.go8.goods.pojo.Product;
import com.go8.goods.pojo.ProductDetail;
import com.go8.goods.pojo.ProductSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
//import com.go8.search.service.SearchService;

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
    /*@Autowired
    private SearchService searchService;*/

    /**
     * 添加商品的同时，调用es的商品索引接口，索引这个被添加的商品信息
     */
    @Override
    public void add(Product product, String detail, ProductSku[] skus) {
        Date now = new Date();
        product.setGmtCreate(now);
        product.setGmtModified(now);
        productMapper.insert(product);

        ProductDetail pdetail = new ProductDetail();
        pdetail.setProductId(product.getId());
        pdetail.setHtml(detail);
        pdetail.setGmtCreate(now);
        pdetail.setGmtModified(now);
        productDetailMapper.insert(pdetail);

        for(ProductSku sku : skus) {
            sku.setProductId(product.getId());
            sku.setGmtCreate(now);
            sku.setGmtModified(now);
            productSkuMapper.insert(sku);
        }

        //同步的方式来同步索引库
        /*try {
            *//*
             * MultiValueMap<String, String> params= new LinkedMultiValueMap<String,
             * String>(); // 也支持中文 params.add("id", product.getId().toString());
             * params.add("title", product.getTitle()); params.add("price",
             * product.getPrice().toString()); params.add("picture", product.getPicture());
             * params.add("catalog_name",
             * catalogMapper.selectByPrimaryKey(product.getCid()).getName()); Brand brand =
             * brandMapper.selectByPrimaryKey(product.getBrandId());
             * params.add("brand_cname", brand.getCname()); params.add("brand_ename",
             * brand.getEname()); params.add("attributes", product.getAttributes());
             *//*

            *//*
             * HttpEntity<MultiValueMap<String, String>> requestEntity = new
             * HttpEntity<MultiValueMap<String, String>>(params, header);
             * ResponseEntity<ServiceResponseDeserializer> srResponse = restTemplate
             * .exchange("http://GO8-SERVICE-SEARCH/search/api", HttpMethod.POST,
             * requestEntity,typeRef); ServiceResponseDeserializer sr =
             * srResponse.getBody();
             *//*

            //同步mysql商品数据到es索引库中
            com.go8.search.pojo.Product index = new com.go8.search.pojo.Product();
            index.setId(product.getId());
            index.setTitle(product.getTitle());
            index.setPrice(product.getPrice());
            index.setPicture(product.getPicture());
            index.setCatalog_name(catalogMapper.selectByPrimaryKey(product.getCid()).getName());
            Brand brand = brandMapper.selectByPrimaryKey(product.getBrandId());
            index.setBrand_cname(brand.getCname());
            index.setBrand_ename(brand.getEname());
            index.setAttributes(product.getAttributes());
            searchService.index(index);

        } catch (Exception e) {
            e.printStackTrace();
            //再试着执行2次
            //记录日志,人工干预解决

        }*/

        //2种方式，异步的方式，使用消息的方式：发个消息就行了；

    }


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


    /*@Override
    public Product getProductById(long id) {
        return productMapper.selectByPrimaryKey(id);
    }


    @Override
    public ProductDetail getDetailByProductId(long productId) {
        return productDetailMapper.selectByPrimaryKey(productId);
    }


    @Override
    public List<Sku> getSkusByProductId(long productId) {
        return productSkuMapper.selectByProductId(productId);
    }


    @Override
    public ProductExt getProductBrandById(Long id) {
        return productMapper.selectProductBrandById(id);
    }*/

}
