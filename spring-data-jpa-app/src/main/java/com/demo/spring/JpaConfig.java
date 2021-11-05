package com.demo.spring;

import org.eclipse.persistence.config.BatchWriting;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceProperty;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration

public class JpaConfig extends JpaBaseConfiguration{
    protected JpaConfig(DataSource dataSource, JpaProperties properties,
                                     ObjectProvider<JtaTransactionManager> jtaTransactionManager) {
        super(dataSource, properties, jtaTransactionManager);
    }

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        return new EclipseLinkJpaVendorAdapter();
    }

    @Override
    protected Map<String, Object> getVendorProperties() {
        final Map<String, Object> ret = new HashMap<>();
        ret.put(PersistenceUnitProperties.BATCH_WRITING, BatchWriting.JDBC);
        ret.put(PersistenceUnitProperties.WEAVING,"false");
        return ret;
    }

   /* @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean emf(DataSource ds) {
        LocalContainerEntityManagerFactoryBean lcb = new LocalContainerEntityManagerFactoryBean();
        lcb.setDataSource(ds);
        lcb.setPackagesToScan("com.demo.spring.entity");
        return lcb;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager txm= new JpaTransactionManager(emf);
        return txm;
    }*/

}
