package com.uteachon.demos.hibernate.dao;

import java.util.List;

import com.uteachon.demos.hibernate.dto.InventoryReport;
import com.uteachon.demos.hibernate.model.StockInventory;

public interface StockInventoryDAO {
	
	public void saveStockInventory(StockInventory si);

	public void updateStockInventory(StockInventory si);

	public void deleteStockInventory(StockInventory si);

	public StockInventory fetchStockInventoryById(Integer serial_id);

	public List<StockInventory> fetchAllStockInventories();

	public int deleteStockInventoryById(Integer serial_id);

	public int deleteStockInventoryAll();

	List<InventoryReport> distributorCountOfInventoryReport();
}
