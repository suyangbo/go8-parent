package com.go8.search.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.go8.search.dao.ProductDao;
import com.go8.search.pojo.Product;
import com.go8.search.pojo.SearchedData;

@Service
public class SearchServiceImpl implements SearchService {
	private static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);
	@Autowired
	private ProductDao productDao;

	@Override
	public void index(Product product) {
		try {
			productDao.index(product);
		} catch (Exception e) {
			logger.error("index product eroor : product info -->"+product,e);
		}
	}

	@Override
	public SearchedData<Product> searchByKeywords(String keywords, int page, int size) {
		return productDao.queryMatch(keywords, page, size);
	}

}
