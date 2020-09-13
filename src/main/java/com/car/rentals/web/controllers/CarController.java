package com.car.rentals.web.controllers;

import com.car.rentals.web.models.Car;
import com.car.rentals.web.services.CarService;
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
@RequestMapping("/car")
public class CarController extends GenericController<Car> {

    @Autowired
    private static final Logger LOG = LoggerFactory.getLogger(CarController.class);

    @Autowired
    CarService carService;

    @Override
    public GenericService<Car> getService() {
        return carService;
    }

    /**
     *  GET
     */
    @GetMapping("/get/all")
    public ResponseEntity<?> listCars(){
        try {
            Iterable<Car> list =carService.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            LOG.error("Error sending object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while fetching data");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> GetCar(@PathVariable("id") String id){
        try {
            Optional<Car> x = carService.getoneobject(id);
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
    public ResponseEntity<?> CarUpdate(@RequestBody Car c){
        try {
            Date date = Calendar.getInstance().getTime();
            c.setUpdated_At(date.toString());
            carService.save(c);
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
    public ResponseEntity<?> CarCreate(@RequestBody Car c){
        try {
            Date date = Calendar.getInstance().getTime();
            c.setCreated_At(date.toString());
            c.setUpdated_At(date.toString());
            carService.save(c);
            return ResponseEntity.ok().body("created Car object");
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }

    /**
     *  DELETE
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> CarDelete(@PathVariable("id") String id){
        try {
            carService.delete(id);
            return ResponseEntity.ok().body("deleted");
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }
}

