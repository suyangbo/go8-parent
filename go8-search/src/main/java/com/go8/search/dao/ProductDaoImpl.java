package com.go8.search.dao;

import com.go8.search.pojo.Product;
import com.go8.search.pojo.SearchedData;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private Client client;
	
	//动词：index,添加一个文档
	@Override
	public IndexResponse index(Product product) {
		try {
			XContentBuilder xcb = XContentFactory.jsonBuilder().startObject().field("id", product.getId())
					.field("picture", product.getPicture()).field("catalog_name", product.getCatalog_name())
					.field("brand_cname", product.getBrand_cname()).field("brand_ename", product.getBrand_ename())
					.field("title", product.getTitle()).field("price", product.getPrice())
					.field("attributes", product.getAttributes()).endObject();
			
			IndexResponse indexResponse = client.prepareIndex().setIndex("goods").setType("_doc")
					.setId(new Long(product.getId()).toString()).setSource(xcb).get();
			return indexResponse;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 站内搜索服务的核心代码
	 */
	@Override
	public SearchedData<Product> queryMatch(String q, int page, int size) {
		SearchedData<Product> results = new SearchedData<Product>();
		SearchResponse response = client
				.prepareSearch()
				.setIndices("goods")
				.setQuery(
						QueryBuilders.multiMatchQuery(q, "catalog_name",
								"title", "attributes"))
				.setFrom((page-1)*size)
				.setSize(size)
				.setFetchSource(
						new String[] { "id", "title", "picture","price" }, null)
				.highlighter(new HighlightBuilder().field("title")
						.preTags("<span style=\"color:red\">")
						.postTags("</span>"))
				.execute().actionGet();

		SearchHits searchHits = response.getHits();
		SearchHit[] hits = searchHits.getHits();
		List<Product> Productes = new ArrayList<Product>();
		for (int i = 0; i < hits.length; i++) {
			SearchHit hit = hits[i];
			Map<String, Object> doc = hit.getSourceAsMap();
			Product Product = new Product();
			Product.setId(Long.parseLong(doc.get("id").toString()));
			Product.setPicture((String)doc.get("picture"));
			Product.setPrice((int)doc.get("price"));
			
			//高亮结果
			Map<String, HighlightField> highlightFields = hit
					.getHighlightFields();
			HighlightField title = highlightFields.get("title");
			if(title != null && title.getFragments()!=null){
				Text[] fragments = title.getFragments();
				Product.setTitle(fragments[0].string());
			}else{
				Product.setTitle((String)doc.get("title"));
			}
			Productes.add(Product);
		}
		results.setData(Productes);
		results.setTotal(searchHits.getTotalHits());
		results.setPage(page);
		results.setSize(size);
		
		return results;
	}

	@Override
	public SearchedData<Product> queryKeyword(String k, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}
}
