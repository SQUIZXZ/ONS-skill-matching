package com.nsa.ons.onsgroupproject.config.database;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Data
@Configuration
@ConfigurationProperties("spring.datasource")
@Slf4j
public class DatabaseConfig  {
    private String driverClassName;
    private String url;
    private String username;
    private String password;


    @Profile("development")
    @Bean
    public String developmentDatabaseConnection() {
        log.info("DB connection for DEV - H2");
        log.info(driverClassName);
        log.info(url);
        return "DB connection for DEV - H2";
    }

    @Profile("production")
    @Bean
    public String productionDatabaseConnection() {
        log.info("DB Connection to RDS_TEST - Low Cost Instance");
        log.info(driverClassName);
        log.info(url);
        return "DB Connection to RDS_TEST - Low Cost Instance";
    }


}
