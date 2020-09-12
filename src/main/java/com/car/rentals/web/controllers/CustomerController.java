package com.car.rentals.web.controllers;

import com.car.rentals.web.models.Customer;
import com.car.rentals.web.services.CustomerService;
import com.car.rentals.web.services.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController extends GenericController<Customer> {

    @Autowired
    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @Override
    public GenericService<Customer> getService() {
        return customerService;
    }

    /**
     *  GET
     */
    @GetMapping("/get/all")
    public ResponseEntity<?> listContracts(){
        try {
            Iterable<Customer> list =customerService.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            LOG.error("Error sending object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while fetching data");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> GetContract(@PathVariable("id") String id){
        try {
            Optional<Customer> x = customerService.getoneobject(id);
            return ResponseEntity.ok().body(x);
        } catch (Exception e) {
            LOG.error("Error sending object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while fetching data");
    }

    /**
     *  PUT
     */
    @PutMapping("/update")
    public ResponseEntity<?> ContractUpdate(@RequestBody Customer c){
        try {
            Date date = Calendar.getInstance().getTime();
            c.setUpdated_At(date.toString());
            customerService.save(c);
            return ResponseEntity.ok().body("ok");
        } catch (Exception e) {
            LOG.error("Error sending object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }

    /**
     *  POST
     */
    @PostMapping("/create")
    public ResponseEntity<?> ContractCreate(@RequestBody Customer c){
        try {
            Date date = Calendar.getInstance().getTime();
            c.setCreated_At(date.toString());
            c.setUpdated_At(date.toString());
            customerService.save(c);
            return ResponseEntity.ok().body("created Contract object");
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }

    /**
     *  DELETE
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> ContractDelete(@PathVariable("id") String id){
        try {
            customerService.delete(id);
            return ResponseEntity.ok().body("deleted");
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }
}

