package com.divergentsl.cms.java;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("dev")
@PropertySource("classpath:/app.properties")
@ComponentScan(basePackages = {"com.divergentsl.cms.dao","com.divergentsl.cms.databaseconnection","com.divergentsl.cms.java"})
public class JavaConfig {	

}
