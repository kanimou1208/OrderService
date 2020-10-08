package com.orderService.models;

import java.util.List;
public class Products {

	public Products() {
	}
private List<ProductList> productList;
private String email;

public Products(List<ProductList> productList, String email) {
	super();
	this.productList = productList;
	this.email = email;
}

public List<ProductList> getProductList() {
	return productList;
}

public void setProductList(List<ProductList> productList) {
	this.productList = productList;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


}
