package com.divergentsl.cms.java;

import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableAspectJAutoProxy
@Profile("dev")
@PropertySource("classpath:/app.properties")
@ComponentScan(basePackages = { "com.divergentsl.cms.dao", "com.divergentsl.cms.databaseconnection",
		"com.divergentsl.cms.java", "com.divergentsl.cms.dto,com.divergentsl.cms.aspect" })
public class JavaConfig {

	@Value("${spring.datasource.url}")
	public String url;
	@Value("${spring.datasource.username}")
	public String username;
	@Value("${spring.datasource.password}")
	public String password;

	@Bean
	public DataSource mysqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(mysqlDataSource());
	}

	/*
	 * @Bean public NamedParameterJdbcTemplate namedParameterJdbcTemplate() { return
	 * new NamedParameterJdbcTemplate(mysqlDataSource()); }
	 */

}
