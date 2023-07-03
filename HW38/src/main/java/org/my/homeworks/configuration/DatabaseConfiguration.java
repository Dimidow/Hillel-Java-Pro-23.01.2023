package org.my.homeworks.configuration;

import javax.sql.DataSource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.my.homeworks.HW38")
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class DatabaseConfiguration {
    private String url;
    private String username;
    private String password;
    private String driverClassName;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
                   .create()
                   .url(url)
                   .username(username)
                   .password(password)
                   .driverClassName(driverClassName)
                   .build();
    }
}
