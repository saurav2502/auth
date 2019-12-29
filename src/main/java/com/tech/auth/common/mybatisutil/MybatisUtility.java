package com.tech.auth.common.mybatisutil;

import com.github.pagehelper.PageInterceptor;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisUtility {
    @Bean
    public PageInterceptor[] pageInterceptors() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("reasonable", "false");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "count=check");
        properties.setProperty("params", "count=countSql");
        pageInterceptor.setProperties(properties);
        return new PageInterceptor[] { pageInterceptor };
    }

}
