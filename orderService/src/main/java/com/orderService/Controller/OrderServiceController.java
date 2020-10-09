package com.orderService.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.orderService.Exception.ProductNotAvailableException;
import com.orderService.models.Orders;
import com.orderService.models.Product;
import com.orderService.models.ProductDetail;
import com.orderService.models.ProductList;
import com.orderService.models.Products;
import com.orderService.repository.OrderRepository;

@RestController
@RequestMapping("/api/orderService")
public class OrderServiceController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	OrderRepository orderRepository;

	@PutMapping
	@RequestMapping("/order")
	@ResponseBody
	private Orders placeAnOrder(@RequestBody Products products) {
		List<Product> Productcollect = getValidProducts(products);
		Orders order = createOrder(products, Productcollect);
		restTemplate.put("http://productCatalog/api/productCatalog/updateQuantity", products);
		return order;

	}

	private Orders createOrder(Products products, List<Product> Productcollect) {
		Orders order = new Orders();
		order.setId(String.valueOf(RandomUtils.nextInt()));
		order.setEmail(products.getEmail());
		order.setOrderDate(new Date());
		List<ProductDetail> collect = Productcollect.stream().map(product -> {
			return new ProductDetail(product.getId(), product.getAvailableQuantity(), product.getPrice());
		}).collect(Collectors.toList());

		long sum = collect.stream().mapToLong(productDetail -> productDetail.getAmount()*productDetail.getQuantity()).sum();
		order.setTotalAmount(sum);
		order.setProductList(collect);
		return order;
	}

	private List<Product> getValidProducts(Products products) {
		List<ProductList> productList = products.getProductList();
		
		List<Product> Productcollect = productList.stream().map(list -> {
			Product product = restTemplate.getForObject(
					"http://productCatalog/api/productCatalog/products/" + list.getProductId(), Product.class);
			if (!(product.getAvailableQuantity() > 0) || !(list.getQuantity() <= product.getAvailableQuantity())) {
				throw new ProductNotAvailableException("REQUESTED PRODUCT" +product.getName()+"IS Not AVAILABLE");
							}
			return new Product(list.getProductId(), product.getName(), product.getPrice(), list.getQuantity());
		}).collect(Collectors.toList());
		return Productcollect;
	}

}
