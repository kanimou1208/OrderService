package com.orderService.models;

public class ProductDetail {

	private String productId;
	private int quantity;
	private Long amount;
	
	public ProductDetail() {
	}

	public ProductDetail(String productId, int quantity, Long amount) {
		this.productId = productId;
		this.quantity = quantity;
		this.amount = amount;
	}



	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public Long getAmount() {
		return amount;
	}



	public void setAmount(Long amount) {
		this.amount = amount;
	}

}
