package com.car.rentals.web.controllers;

import com.car.rentals.web.models.Car;
import com.car.rentals.web.services.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class RestfulController {

    @Autowired
    private static final Logger LOGGER = LoggerFactory.getLogger(RestfulController.class.getName());

    @Autowired
    private CarService carService;


    /**
     * Retrieve Operations
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        try {
            return ResponseEntity.ok().body(carService.getAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not found");
    }

    /**
     * Create Operations
     * @param car
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> createEntity(@RequestBody Car car){
        try {

            return ResponseEntity.ok().body(carService.create(car));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not created");
    }

    /**
     * Update Operations
     * @param car
     * @return
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> createEntity(@PathVariable String id, @RequestBody Car car){
        try {

            return ResponseEntity.ok().body(carService.update(id, car));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not created");
    }

    /**
     *  Delete Operations
     * @param id
     * @return
     */
    @DeleteMapping("/delete/car/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        try {
            carService.delete(id);
            return ResponseEntity.ok().body("successfully deleted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not found");
    }


}
