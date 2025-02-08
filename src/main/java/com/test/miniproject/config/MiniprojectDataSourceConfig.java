package com.test.miniproject.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
// import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

// @Configuration
// @EnableTransactionManagement
// @EnableJpaRepositories(
//     basePackages = "com.test.miniproject.repository.miniproject",
//     entityManagerFactoryRef = "miniprojectEntityManagerFactory",
//     transactionManagerRef = "miniprojectTransactionManager"
// )
public class MiniprojectDataSourceConfig {
    // @Bean(name = "miniprojectDataSource")
    // @ConfigurationProperties(prefix = "spring.datasource.miniproject")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    // @Bean(name = "miniprojectEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("miniprojectDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.test.miniproject.entity") // 엔티티 클래스 패키지
                .persistenceUnit("miniprojectPU")
                .build();
    }

    // @Bean(name = "miniprojectTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("miniprojectEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
