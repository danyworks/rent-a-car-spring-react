package com.car.rentals.web.controllers;

import com.car.rentals.web.models.Order;
import com.car.rentals.web.services.OrderService;
import com.car.rentals.web.services.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController extends GenericController<Order> {

    @Autowired
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @Override
    public GenericService<Order> getService() {
        return orderService;
    }

    /**
     *  GET
     */
    @GetMapping("/get/all")
    public ResponseEntity<?> listOrders(){
        try {
            Iterable<Order> list =orderService.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            LOG.error("Error sending object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while fetching data");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> GetOrder(@PathVariable("id") String id){
        try {
            Optional<Order> x = orderService.getoneobject(id);
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
    public ResponseEntity<?> OrderUpdate(@RequestBody Order c){
        try {
            Date date = Calendar.getInstance().getTime();
            c.setUpdated_At(date.toString());
            orderService.save(c);
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
    public ResponseEntity<?> OrderCreate(@RequestBody Order c){
        try {
            Date date = Calendar.getInstance().getTime();
            c.setCreated_At(date.toString());
            c.setUpdated_At(date.toString());
            orderService.save(c);
            return ResponseEntity.ok().body("created Order object");
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }

    /**
     *  DELETE
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> OrderDelete(@PathVariable("id") String id){
        try {
            orderService.delete(id);
            return ResponseEntity.ok().body("deleted");
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }
}

