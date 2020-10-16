package com.uteachon.demos.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.uteachon.demos.hibernate.conf.HibernateConf;
import com.uteachon.demos.hibernate.dao.StockInventoryDAO;
import com.uteachon.demos.hibernate.dao.StockInventoryDAOImpl;
import com.uteachon.demos.hibernate.model.StockInventory;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// ClassPathXmlApplicationContext r=new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	//LocalSessionFactoryBean
        //BeanFactory factory=r.getBean(name);
    	//basicdatas
    	//r.getBean("");
    	
    	AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(HibernateConf.class);
    	
    	StockInventoryDAO stockInventoryDAO = context.getBean(StockInventoryDAO.class);
    	
    	//stockInventoryDAO.deleteStockInventoryById(1);
    	//stockInventoryDAO.fetchAllStockInventories();
    	
    	StockInventory si = new StockInventory();
    	si.setDistributor("ZYX");
    	si.setStatus(3);
    	stockInventoryDAO.saveStockInventory(si);
    	
    	
    }
}
