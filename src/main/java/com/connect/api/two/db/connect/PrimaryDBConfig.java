package com.connect.api.two.db.connect;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef="primaryEntityManagerFactory",
transactionManagerRef ="primaryTransactionManager",
basePackages={"com.connect.api.two.db.connect.primRepo"})

public class PrimaryDBConfig {
	
	
	@Primary
	@Bean(name="primaryDataSource")
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource(){
		return  DataSourceBuilder.create().build();
	} 
	
	@Primary
	@Bean(name = "primaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
			EntityManagerFactoryBuilder builder,@Qualifier("primaryDataSource") DataSource dataSource){
		
		return builder.dataSource(dataSource)
				.packages("com.connect.api.two.db.connect.PrimEntity")
				.build();
	}
			
   @Primary
   @Bean(name="primaryTransactionManager")
	public PlatformTransactionManager primaryTransaction(@Qualifier("primaryEntityManagerFactory") EntityManagerFactory 
			primaryEntityManagerFactory){
		
		return new JpaTransactionManager(primaryEntityManagerFactory);
		
		
	}
}
