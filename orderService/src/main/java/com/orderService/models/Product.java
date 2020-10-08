package com.orderService.models;


import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="Product")
public class Product {
	private String id;
	private String name;
	private String image;
	private Long price;
	private String description;
	private int availableQuantity;

	public Product() {

	}

	public Product(String id, String name, String image, Long price, String description, int availableQuantity) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.description = description;
		this.availableQuantity = availableQuantity;
	}

	public Product(String id, String name, Long price, int availableQuantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

}
