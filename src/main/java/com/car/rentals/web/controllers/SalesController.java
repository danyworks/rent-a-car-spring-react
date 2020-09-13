package com.car.rentals.web.controllers;

import com.car.rentals.web.models.Sales;
import com.car.rentals.web.services.SalesService;
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
@RequestMapping("/sales")
public class SalesController extends GenericController<Sales> {

    @Autowired
    private static final Logger LOG = LoggerFactory.getLogger(SalesController.class);

    @Autowired
    SalesService salesService;

    @Override
    public GenericService<Sales> getService() {
        return salesService;
    }

    /**
     *  GET
     */
    @GetMapping("/get/all")
    public ResponseEntity<?> listSaless(){
        try {
            Iterable<Sales> list =salesService.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            LOG.error("Error sending object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while fetching data");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> GetSales(@PathVariable("id") String id){
        try {
            Optional<Sales> x = salesService.getoneobject(id);
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
    public ResponseEntity<?> SalesUpdate(@RequestBody Sales c){
        try {
            Date date = Calendar.getInstance().getTime();
            c.setUpdated_At(date.toString());
            salesService.save(c);
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
    public ResponseEntity<?> SalesCreate(@RequestBody Sales c){
        try {
            Date date = Calendar.getInstance().getTime();
            c.setCreated_At(date.toString());
            c.setUpdated_At(date.toString());
            salesService.save(c);
            return ResponseEntity.ok().body("created Sales object");
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }

    /**
     *  DELETE
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> SalesDelete(@PathVariable("id") String id){
        try {
            salesService.delete(id);
            return ResponseEntity.ok().body("deleted");
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }
}

