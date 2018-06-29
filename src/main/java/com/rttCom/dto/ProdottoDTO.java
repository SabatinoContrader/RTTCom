package com.rttCom.dto;

import javax.persistence.Column;

public class ProdottoDTO {

	private int id;
	private String ean;
	private String category;
	private String model;
	private String manufacturer;
	private String description;
	private String long_description;
	private double sell_price;

	public ProdottoDTO() {

	}

	public ProdottoDTO(int id, String ean, String category, String model, String manufacturer, String description,
			String long_description, Double sell_price) {
		this.id = id;
		this.ean = ean;
		this.category = category;
		this.model = model;
		this.manufacturer = manufacturer;
		this.description = description;
		this.long_description = long_description;
		this.sell_price = sell_price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLongDescription() {
		return long_description;
	}

	public void setLongDescription(String longdescription) {
		this.long_description = longdescription;
	}

	public double getSellPrice() {
		return sell_price;
	}

	public void setSellPrice(double sellprice) {
		this.sell_price = sellprice;
	}

}
