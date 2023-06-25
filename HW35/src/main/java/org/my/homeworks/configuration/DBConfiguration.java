package org.my.homeworks.configuration;

import java.sql.SQLException;
import javax.sql.DataSource;

import com.mysql.cj.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class DBConfiguration {

    @Bean
    public DataSource dataSource() throws SQLException {
        return new SimpleDriverDataSource(new Driver(), "jdbc:mysql://localhost:3306/HW35", "root", "1qazXSW@3edc");
    }
}
