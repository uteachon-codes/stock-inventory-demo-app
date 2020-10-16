package com.uteachon.demos.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity(name = "StockInventory")
@Table(name = "STOCK_INVENTORY")
public class StockInventory implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public StockInventory() {
		// TODO Auto-generated constructor stub
	}
	
	public StockInventory(String distributor, int status) {
		setDistributor(distributor);
		setStatus(status);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serial_id")
	private int serial_id;
	
	@Column(name = "distributor")
	private String distributor;
	
	@Column(name = "status")
	private int status;

	public int getSerial_id() {
		return serial_id;
	}

	public void setSerial_id(int serial_id) {
		this.serial_id = serial_id;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
}
