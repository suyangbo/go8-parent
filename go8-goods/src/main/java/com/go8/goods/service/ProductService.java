package com.go8.goods.service;

import com.go8.goods.pojo.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(int page,int size,Product product);

    long getCount(Product p);

    void updatePartial(Product p);

}
