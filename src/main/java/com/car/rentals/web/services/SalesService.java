package com.car.rentals.web.services;


import com.car.rentals.web.models.Sales;
import com.car.rentals.web.repositories.GenericRepository;
import com.car.rentals.web.repositories.ISalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SalesService extends GenericService<Sales> {

    @Autowired
    ISalesRepository salesRepository;


    @Override
    public GenericRepository<Sales> getRepository() {
        return this.salesRepository;
    }
}
