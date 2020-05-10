package com.go8.search.service;

import com.go8.search.pojo.Product;
import com.go8.search.pojo.SearchedData;

public interface SearchService {
	void index(Product product);
	
	SearchedData<Product> searchByKeywords(String keywords, int page, int size);
}
