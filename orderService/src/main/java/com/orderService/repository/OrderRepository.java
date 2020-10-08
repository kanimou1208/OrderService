package com.orderService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.orderService.models.Orders;

public interface OrderRepository extends MongoRepository<Orders, String>{

}
