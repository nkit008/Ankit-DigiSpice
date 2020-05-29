package com.digispice.cci.zambia.connection;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public class EntityConnection {

	public EntityManagerFactory getBeatsEntityManager() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(GetConnection.loadProp("jdbc.driver"));
		dataSource.setUrl(GetConnection.loadProp("jdbc.beats.url"));
		dataSource.setUsername(GetConnection.loadProp("jdbc.beats.username"));
		dataSource.setPassword(GetConnection.loadProp("jdbc.beats.password"));

		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan(new String[] { "com.digispice" });

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", GetConnection.loadProp("jpa.hibernate.dialect"));
		em.setJpaPropertyMap(properties);
		em.afterPropertiesSet();
		return (EntityManagerFactory) em.getObject();
	}

}
