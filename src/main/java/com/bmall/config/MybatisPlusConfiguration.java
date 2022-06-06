package com.bmall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement

@MapperScan("com.bmall.mapper")
@Configuration
public class MybatisPlusConfiguration {
}
