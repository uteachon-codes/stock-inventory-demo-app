package com.uteachon.demos.hibernate.conf;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.uteachon.demos.hibernate.dao.StockInventoryDAO;
import com.uteachon.demos.hibernate.dao.StockInventoryDAOImpl;

//@Component
@Configuration
@EnableTransactionManagement
//@ComponentScan({"com.uteachon.demos.hibernate.dao", "com.uteachon.demos.hibernate.model"})
public class HibernateConf {

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(
        		new String[] {
        				"com.uteachon.demos.hibernate.dao", "com.uteachon.demos.hibernate.model"}); 
        sessionFactory.setAnnotatedPackages(new String[] {"com.uteachon.demos.hibernate.dao", "com.uteachon.demos.hibernate.model"});
        sessionFactory.setHibernateProperties(hibernateProperties());
 
        return sessionFactory;
    }
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://10.0.0.237:3306/student_info_db");
        dataSource.setUsername("studentdbuser");
        dataSource.setPassword("password1");
 
        return dataSource;
	}
	
    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
          = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
	
	private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
          "hibernate.hbm2ddl.auto", "none"); //create-drop
        hibernateProperties.setProperty(
          "hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
 
        return hibernateProperties;
    }
	
	@Bean
	public StockInventoryDAO stockInventoryDAO() {
		return new StockInventoryDAOImpl();
	}
	
}
