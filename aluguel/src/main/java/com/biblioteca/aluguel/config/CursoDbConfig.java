package com.biblioteca.aluguel.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "cursoEntityManagerFactory", transactionManagerRef = "cursoTransactionManager", basePackages = {
"com.biblioteca.aluguel.curso.repository" })
public class CursoDbConfig {

	@Bean(name = "cursoDataSource")
	@ConfigurationProperties(prefix = "curso.spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "cursoEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean cursoEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("cursoDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.biblioteca.aluguel.curso.model").persistenceUnit("curso")
				.build();
	}

	@Bean(name = "cursoTransactionManager")
	public PlatformTransactionManager cursoTransactionManager(
			@Qualifier("cursoEntityManagerFactory") EntityManagerFactory cursoEntityManagerFactory) {
		return new JpaTransactionManager(cursoEntityManagerFactory);
	}
}
