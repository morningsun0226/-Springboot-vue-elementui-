package com.morningsun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        //1.添加CORS配置
        CorsConfiguration config = new CorsConfiguration();
        //1.1.放行指定原始域
        config.addAllowedOrigin("*");
        //1.2.设置是否发送Cookie
        config.setAllowCredentials(false);
        //1.3.放行指定请求方式
        config.addAllowedMethod("*");
        //1.4.放行指定请求头信息
        config.addAllowedHeader("*");
        //1.5.设置显示指定请求头信息
        config.addExposedHeader("*");
        //2.添加映射路径
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", config);
        //3.返回新的CorsFilter
        return new CorsFilter(corsConfigurationSource);
    }
}
