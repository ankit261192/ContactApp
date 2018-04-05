package com.ds.contactapp.config;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//to specify this is configuraition class
@Configuration

//to specify base package
@ComponentScan(basePackages={"com.ds.contactapp.dao","com.ds.contactapp.services"})
public class SpringRootConfig {
//to add services,dao,email sender,datasource etc.(all business layer beans)
	
	@Bean
	public BasicDataSource getDataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/contactapp");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setInitialSize(3);
		ds.setTestOnBorrow(true);//if any connection is borrowed from connection pool it will be tested
		ds.setValidationQuery("select 1");// to test connection if it is valid or not
		ds.setDefaultAutoCommit(true);//by defult query will be autocommited
		return ds;
		
	}
}
