package com.example.plantdelivery.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "com.example.plantdelivery.datasource")
    public DataSource getDataSource(DataSourceProperties dataSourceProperties) {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password(securePasswordService());
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/plant");
        return dataSourceBuilder.build();
    }

    public String securePasswordService() {
        return "sa1234";
    }
}
