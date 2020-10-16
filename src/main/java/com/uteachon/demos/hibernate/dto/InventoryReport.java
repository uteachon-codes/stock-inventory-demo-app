package com.uteachon.demos.hibernate.dto;

public class InventoryReport {
    private String distributor;
    private long inventory_count;
	public long getInventory_count() {
		return inventory_count;
	}
	public void setInventory_count(long inventory_count) {
		this.inventory_count = inventory_count;
	}
	public String getDistributor() {
		return distributor;
	}
	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}
	
	@Override
	public String toString() {
		return distributor + " | " + inventory_count;
	}
}
