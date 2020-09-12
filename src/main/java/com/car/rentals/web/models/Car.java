package com.car.rentals.web.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.*;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Document("cars")
public class Car {

    // ID for use internally in database
    @Id
    private String ID;

    @Indexed(name = "CarName")
    private String Name;
    private String Description;
    private double Price_Per_Day;

    // Car Owner Details
    private String Vehicle_Owner_Name;
    private String Vehicle_Description;
    private List<Image> Vehicle_Images;




    private boolean inWorkshop;
    private String Created_At;
    private String Updated_At;
}