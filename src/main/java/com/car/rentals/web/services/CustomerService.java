package com.car.rentals.web.services;

import com.car.rentals.web.models.Customer;
import com.car.rentals.web.repositories.GenericRepository;
import com.car.rentals.web.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService extends GenericService<Customer> {

    @Autowired
    ICustomerRepository iCustomerRepository;


    @Override
    public GenericRepository<Customer> getRepository() {
        return this.iCustomerRepository;
    }
}
