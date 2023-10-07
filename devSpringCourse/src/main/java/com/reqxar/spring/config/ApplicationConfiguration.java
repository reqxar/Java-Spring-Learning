package com.reqxar.spring.config;

import com.reqxar.spring.database.pool.ConnectionPool;
import com.reqxar.spring.web.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySources(
        {
                @PropertySource("classpath:oracle.properties"),
                @PropertySource("classpath:postgres.properties")
        }
)
@ComponentScan(basePackages = "com.reqxar.spring")
@Import(WebConfiguration.class)
public class ApplicationConfiguration {
        @Bean("pool2")
        public ConnectionPool pool2(@Value("${oracle.url}") String url,
                                    @Value("${oracle.username}")String username,
                                    @Value("${oracle.password}") String password){
                return new ConnectionPool(url, username, password);
        }
}
