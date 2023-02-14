package com.example.iSpanHotel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    // 當前跨域請求最大有效時長。這裡默認1天
    private static final long MAX_AGE = 24 * 60 * 60;

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("http://localhost:8081"); // 1 設置訪問源位址
        corsConfiguration.addAllowedOrigin("*"); // 1 設置訪問源位址
        corsConfiguration.addAllowedHeader("*"); // 2 設置訪問源請求頭
        corsConfiguration.addAllowedMethod("*"); // 3 設置訪問源請求方法
        corsConfiguration.setMaxAge(MAX_AGE);
        source.registerCorsConfiguration("/**", corsConfiguration); // 4 對介面配置跨域設置
        return new CorsFilter(source);
    }
}

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//@Configuration
//public class CorsConfig {
//    @Bean
//    public CorsFilter corsFilter() {
//        CorsConfiguration config = new CorsConfiguration();
//
//        //允許跨網域請求的來源
//        config.addAllowedOrigin("/*");
//
//        //允許跨域攜帶cookie資訊，預設跨網域請求是不攜帶cookie資訊的。
//        config.setAllowCredentials(true);
//
//        //允許使用那些請求方式
//        config.addAllowedMethod("/*");
//        //config.setAllowedMethods(Arrays.asList("GET", "PUT", "POST","DELETE"));
//        //config.addAllowedMethod(HttpMethod.POST);
//
//        //允許哪些Header
//        config.addAllowedHeader("/*");
//        //config.addAllowedHeader("x-firebase-auth");
//
//        //可獲取哪些Header（因為跨網域預設不能取得全部Header資訊）
//        config.addExposedHeader("/*");
//        //config.addExposedHeader("Content-Type");
//        //config.addExposedHeader( "X-Requested-With");
//        //config.addExposedHeader("accept");
//        //config.addExposedHeader("Origin");
//        //config.addExposedHeader( "Access-Control-Request-Method");
//        //config.addExposedHeader("Access-Control-Request-Headers");
//
//
//        //映射路徑
//        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
//        configSource.registerCorsConfiguration("/**", config);
//
//        //return一個的CorsFilter.
//        return new CorsFilter(configSource);
//    }
//
//}
