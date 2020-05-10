package com.go8.goods.service;

import com.go8.goods.pojo.Product;
import com.go8.goods.pojo.ProductDetail;
import com.go8.goods.pojo.ProductExt;
import com.go8.goods.pojo.ProductSku;

import java.util.List;

public interface ProductService {

    void add(Product product, String detail, ProductSku[] skus);

    List<Product> getProducts(int page,int size,Product product);

    ProductExt getProductBrandById(Long id);

    long getCount(Product p);

    void updatePartial(Product p);

    Product getProductById(long id);

    ProductDetail getDetailByProductId(long productId);

    List<ProductSku> getSkusByProductId(long productId);

}
