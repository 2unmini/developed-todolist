package com.example.developedtodolist.config;

import com.example.developedtodolist.Filter.LoginFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig { // 수동 빈 등록

    @Bean
    public FilterRegistrationBean loginFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>(); //
        filterRegistrationBean.setFilter(new LoginFilter()); // 로그인 필터 등록
        filterRegistrationBean.setOrder(1); // 필터 순서 설정
        filterRegistrationBean.addUrlPatterns("/*"); //*= 전체 url에 필터 적용
        return filterRegistrationBean;
    }
}
