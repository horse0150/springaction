package com.wwb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Import({JpaConfig.class})
@Configuration
@ComponentScan(basePackages = {"com.wwb"})
@EnableTransactionManagement
public class RootConfig {
}
