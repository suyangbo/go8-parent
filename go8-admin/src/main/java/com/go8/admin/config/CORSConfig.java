package com.go8.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * CORS configuration
 */
@Configuration
public class CORSConfig {

    //该方法过时
    /*
     * @Bean public WebMvcConfigurer corsConfigurer() { return new
     * WebMvcConfigurerAdapter() {
     *
     * @Override public void addCorsMappings(CorsRegistry registry) {
     * registry.addMapping("/**")
     * .allowedOrigins("http://127.0.0.1:8000,http://localhost:8000")
     * .allowedMethods("POST,GET, OPTIONS,DELETE,PUT")
     * .allowedHeaders("Content-Type,ContentType,Access-Control-Allow-Headers,Access-Control-Allow-Origin, Authorization, X-Requested-With"
     * ) .allowCredentials(true); } }; }
     */

    //该方法不灵
    /*
     * @Bean public WebMvcConfigurer createConfigurer() {
     * System.out.println("跨越配置开始了。。。。。。。。。。。。。。。。"); return new
     * CORSWebMvcConfigurer(); }
     */

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 1允许任何域名使用
        corsConfiguration.addAllowedHeader("*"); // 2允许任何头
        corsConfiguration.addAllowedMethod("*"); // 3允许任何方法（post、get等）
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }
}
