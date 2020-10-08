package com.orderService.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="orders")
public class Orders {

	private String id;
	private Date orderDate;
	private String email;
	private List<ProductDetail> productDetails;
	private Long totalAmount;
	
	public Orders() {
	}
   
	

	public Orders(String id, Date orderDate, String email, List<ProductDetail> productList, Long totalAmount) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.email = email;
		this.productDetails = productDetails;
		this.totalAmount = totalAmount;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<ProductDetail> getProductList() {
		return productDetails;
	}

	public void setProductList(List<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

}
