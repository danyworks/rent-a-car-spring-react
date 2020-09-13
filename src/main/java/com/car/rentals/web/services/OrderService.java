package com.car.rentals.web.services;


import com.car.rentals.web.models.Employee;
import com.car.rentals.web.models.Order;
import com.car.rentals.web.repositories.EmployeeRepository;
import com.car.rentals.web.repositories.GenericRepository;
import com.car.rentals.web.repositories.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService extends GenericService<Order> {

    @Autowired
    IOrderRepository iOrderRepository;


    @Override
    public GenericRepository<Order> getRepository() {
        return this.iOrderRepository;
    }
}
