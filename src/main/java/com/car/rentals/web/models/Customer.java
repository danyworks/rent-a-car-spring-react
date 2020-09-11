package com.car.rentals.web.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Document("customers")
public class Customer {

    // ID for use internally in database
    @Id
    private String ID;
    private String Profile_ID;

    private String Email;
    private String First_Name;
    private String Last_Name;

    // atleast one Capital and one Special Character and one Numeric Character
    private String Password;

    private String Phone_Number;
    private String Address;

    // Credit Debit Card details
    private String Cardholder_Name;
    private String Card_Number;
    private String Month;
    private String Year;
    private String CVV;

    private boolean isProcessed;
    private String Created_At;
    private String Updated_At;
}