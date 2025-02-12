package com.sample.employeemanagement.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sample.employeemanagement.service.DepartmentService;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final DepartmentService departmentService;

    public WebConfig(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringConverter(departmentService));
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}
