package com.car.rentals.web.services;


import com.car.rentals.web.models.Car;
import com.car.rentals.web.models.SeqGen;
import com.car.rentals.web.repositories.ICarRepository;
import com.car.rentals.web.repositories.ISeqGenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    ICarRepository iCarRepository;

    @Autowired
    ISeqGenRepository iSeqGenRepository;

    //Create operation
    public String create(Car car) {
        Car toSaveCar = new Car();
        Date date = Calendar.getInstance().getTime();
        toSaveCar.setID(this.generateID("car"));
        toSaveCar.setName(car.getName());
        toSaveCar.setDescription(car.getDescription());
        toSaveCar.setCreated_At(date.toString());
        toSaveCar.setUpdated_At(date.toString());
        toSaveCar.setPrice_Per_Day(car.getPrice_Per_Day());
        toSaveCar.setVehicle_Owner_Name(car.getVehicle_Owner_Name());
        toSaveCar.setVehicle_Description(car.getVehicle_Description());
        iCarRepository.save(car);
        return "created";
    }


    //Retrieve Operation
    public List<Car> getAll(){
        return iCarRepository.findAll();
    }

    //Update Operation
    public String update(String ID, Car car){
        Optional<Car> tempCar = iCarRepository.findById(ID);
        Date date = Calendar.getInstance().getTime();
        if (tempCar.isPresent()){
            Car updateCar = tempCar.get();
            updateCar.setName(car.getName());
            updateCar.setDescription(car.getDescription());
            updateCar.setPrice_Per_Day(car.getPrice_Per_Day());
            updateCar.setInWorkshop(car.isInWorkshop());
            updateCar.setUpdated_At(date.toString());
            updateCar.setVehicle_Owner_Name(car.getVehicle_Owner_Name());
            updateCar.setVehicle_Description(car.getVehicle_Description());
            iCarRepository.save(updateCar);
            return "car updated";
        }
        return "car not present with the given ID";
    }


    //Delete Operations
    public void deleteAll(){
        iCarRepository.deleteAll();
    }

    public void delete(String ID){
        Optional<Car> tempCar = iCarRepository.findById(ID);
        if (tempCar.isPresent()){
            Car car = tempCar.get();
            iCarRepository.delete(car);
        }
    }


    public String generateID(String ModelType ){
        SeqGen sequence = new SeqGen();
        String generatedID;
        int temp =0;
        if(ModelType.toLowerCase().equals("car")){
            sequence.setID("VEH"+"-"+"100");
            generatedID = sequence.getID()+sequence.getSEQ();
            sequence.setSEQ(temp++);
            iSeqGenRepository.save(sequence);
            return generatedID;
        }
        return null;
    }
}
