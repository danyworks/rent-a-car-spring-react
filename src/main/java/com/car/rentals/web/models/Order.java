package com.car.rentals.web.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@RequiredArgsConstructor
@Getter
@Setter
@Document("orders")
public class Order {

    // ID for use internally in database
    @Id
    private String Order_ID;

    // Rented Car Details
    private String Car_ID;
    private String Rented_From;
    private String Rented_Till;
    private String Total_Amount;
    private boolean Amount_Received;
    private String Rental_Period;

    // Rented Customer Contact
    private String Customer_ID;

    // Emergency Contact
    private double Latitude;
    private double Longitude;
    private double Altitude;
    private String Temperature;
    private String Velocity;
    private boolean crossedLimits;

    private boolean isProcessed;
    private String Created_At;
    private String Updated_At;

}
