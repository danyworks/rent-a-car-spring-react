package com.car.rentals.web.repositories;


import com.car.rentals.web.models.Customer;
import com.car.rentals.web.models.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends GenericRepository<Order> {


}
