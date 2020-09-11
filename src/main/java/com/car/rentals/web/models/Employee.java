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
@Document("employees")
public class Employee {

    // ID for use internally in database
    @Id
    private String ID;

    // Company Related Data
    private String Employee_ID;
    private String Employee_Since;
    private String Employee_Role_ID;
    private String Employee_Department;

    private String Salary;
    private String Bank_Details;


    //Personal Data
    private String First_Name;
    private String Last_Name;
    private String Birth_Date;
    private String Phone_Number;
    private String Email;
    // atleast one Capital and one Special Character and one Numeric Character
    private String Password;
    private String Address;

    private String Remarks;


    private boolean isProcessed;
    private String Created_At;
    private String Updated_At;
}