package spring_boot_demo.spring_boot_demo.datasource;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostgresDatasource {
	@Bean 
	@ConfigurationProperties("app.datasource")
	public HikariDataSource hikariDataSource() {
		return DataSourceBuilder	
				.create()
				.type(HikariDataSource.class)
				.build();
	}
}
