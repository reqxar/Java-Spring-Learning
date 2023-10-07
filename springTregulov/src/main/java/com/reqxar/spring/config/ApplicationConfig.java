package com.reqxar.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.reqxar.spring")
@PropertySource("classpath:person.properties")
public class ApplicationConfig {
}
