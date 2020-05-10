package com.go8.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.go8")
@MapperScan({"com.go8.sso.mapper","com.go8.cms.mapper","com.go8.goods.mapper","com.go8.trade.mapper"})
public class MallApplication {
	public static void main(String[] args) {
		SpringApplication.run(MallApplication.class, args);
	}
	@Bean
	public CartCache getCartCache() {
		return new CartCache();
	}
}
