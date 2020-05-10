package com.go8.search.dao;

import org.elasticsearch.action.index.IndexResponse;
import com.go8.search.pojo.Product;
import com.go8.search.pojo.SearchedData;

public interface ProductDao {
	IndexResponse index(Product product);
	
	SearchedData<Product> queryMatch(String q, int page, int size);
	
	SearchedData<Product> queryKeyword(String k, int page, int size);
}
