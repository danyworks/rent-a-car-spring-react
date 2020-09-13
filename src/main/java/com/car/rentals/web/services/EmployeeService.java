package com.car.rentals.web.services;


import com.car.rentals.web.models.Employee;
import com.car.rentals.web.repositories.EmployeeRepository;
import com.car.rentals.web.repositories.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService extends GenericService<Employee> {

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public GenericRepository<Employee> getRepository() {
        return this.employeeRepository;
    }
}
