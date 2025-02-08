package com.test.miniproject.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
// import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

// @Configuration
// @EnableTransactionManagement
// @EnableJpaRepositories(
//         basePackages = "com.test.miniproject.repository.member",
//         entityManagerFactoryRef = "memberEntityManagerFactory",
//         transactionManagerRef = "memberTransactionManager"
// )
public class MemberDataSourceConfig {

    // @Bean(name = "memberDataSource")
    // @ConfigurationProperties(prefix = "spring.datasource.member")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    // @Bean(name = "memberEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("memberDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.test.miniproject.entity") // Member 관련 Entity 클래스 패키지
                .persistenceUnit("memberPU")
                .build();
    }

    // @Bean(name = "memberTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("memberEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
