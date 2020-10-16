package com.uteachon.demos.hibernate;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.uteachon.demos.hibernate.conf.HibernateConf;
import com.uteachon.demos.hibernate.dao.StockInventoryDAO;
import com.uteachon.demos.hibernate.dto.InventoryReport;
import com.uteachon.demos.hibernate.model.StockInventory;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private static StockInventoryDAO stockInventoryDAO;

	@BeforeAll
	public static void loadSpringConfigAnnotation() {
    	
    	AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(HibernateConf.class);
    	
    	stockInventoryDAO = context.getBean(StockInventoryDAO.class);
	}
	
    @Test
    @Disabled
    public void deleteStockInventoryAll() {
    	int records = stockInventoryDAO.deleteStockInventoryAll();
    	//assertTrue(records > 0);
    }
	
	@Test
	public void saveStockInventory() {
		StockInventory si1 = new StockInventory("167", 1);
		StockInventory si2 = new StockInventory("168", 1);
		StockInventory si3 = new StockInventory("167", 3);
		StockInventory si4 = new StockInventory("190", 3);
		StockInventory si5 = new StockInventory("190", 5);
		stockInventoryDAO.saveStockInventory(si1);
		stockInventoryDAO.saveStockInventory(si2);
		stockInventoryDAO.saveStockInventory(si3);
		stockInventoryDAO.saveStockInventory(si4);
		stockInventoryDAO.saveStockInventory(si5);
	}
	
    @Test
    @Disabled
    public void deleteStockInventoryById() {
    	int records = stockInventoryDAO.deleteStockInventoryById(4);
    	//assertTrue(records > 0);
    }
    
    @Test
    public void distributorCountOfInventoryReport() {
    	List<InventoryReport> irReport = stockInventoryDAO.distributorCountOfInventoryReport();
    	assertTrue(irReport.size() > 0);
    	
    	System.out.println("Distributor |" + " Count of Inventory");
    	System.out.println("---------------------------------");
    	for (InventoryReport inventoryReport : irReport) {
    		System.out.println(inventoryReport);
		}
    }
}
