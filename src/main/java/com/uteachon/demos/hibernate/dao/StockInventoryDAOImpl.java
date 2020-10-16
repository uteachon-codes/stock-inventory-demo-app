package com.uteachon.demos.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uteachon.demos.hibernate.dto.InventoryReport;
import com.uteachon.demos.hibernate.model.StockInventory;

//@Component
@Repository
//@Service
@Transactional
public class StockInventoryDAOImpl implements StockInventoryDAO {

	@Autowired
	//@Qualifier("sessionFactory")
	public SessionFactory sessionFactory;

	// method to save StockInventory
	@Override
	public void saveStockInventory(StockInventory si) {
		sessionFactory.getCurrentSession().save(si);
	}

	// method to update StockInventory
	@Override
	public void updateStockInventory(StockInventory si) {
		sessionFactory.getCurrentSession().update(si);
	}

	// method to delete StockInventory
	@Override
	public void deleteStockInventory(StockInventory si) {
		sessionFactory.getCurrentSession().delete(si);
	}
	
	@Override
	public int deleteStockInventoryById(Integer serial_id) {
		Query q = sessionFactory.getCurrentSession().createQuery("delete StockInventory where serial_id = :serial_id");
	    q.setParameter("serial_id", serial_id);
		int records = q.executeUpdate();
		return records;
	}
	
	@Override
	public int deleteStockInventoryAll() {
		Query q = sessionFactory.getCurrentSession().createQuery("delete StockInventory");
		int records = q.executeUpdate();
		return records;
	}

	// method to return one StockInventory of given serial_id
	@Override
	public StockInventory fetchStockInventoryById(Integer serial_id) {
		StockInventory si = sessionFactory.getCurrentSession().load(StockInventory.class, serial_id);
		return si;
	}

	// method to return all StockInventory entries
	@Override
	public List<StockInventory> fetchAllStockInventories() { 
		@SuppressWarnings("unchecked")
		TypedQuery<StockInventory> query = sessionFactory.getCurrentSession().createQuery("from StockInventory");
        return query.getResultList();
	}
	
	@Override
	public List<InventoryReport> distributorCountOfInventoryReport() {
		List<InventoryReport> inventoryReportList = new ArrayList<InventoryReport>();
		
		TypedQuery<?> query = sessionFactory.getCurrentSession().createQuery("select si.distributor, count(si.distributor) from StockInventory as si group by si.distributor");
		
		List<?> list = query.getResultList();
		for(int i=0; i<list.size(); i++) {
			InventoryReport ir = new InventoryReport();
			Object[] row = (Object[]) list.get(i);
			//System.out.println(row[0]+", "+ row[1]);
			ir.setDistributor((String)row[0]);
			ir.setInventory_count((long)row[1]);
			inventoryReportList.add(ir);
		}
		
        return inventoryReportList;
	}
}
