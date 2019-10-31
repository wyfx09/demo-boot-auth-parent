package com.example.demoauthserver.config.db;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by keets on 2016/12/5.
 */
@Configuration
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
public class DatasourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.auth")
    @Primary
    public DataSource oauthDataSource() {
        return DataSourceBuilder.create().build();
    }



}
