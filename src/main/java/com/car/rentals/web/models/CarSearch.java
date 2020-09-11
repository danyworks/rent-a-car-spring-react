package com.car.rentals.web.models;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@RequiredArgsConstructor
@Getter
@Setter
@Document("carsearch")
public class CarSearch {

    // ID for use internally in database
    @Id
    private String Search_ID;

    private String User_Location;
    private String Pick_Up_Loc;
    private String Return_Loc;
    private String Pick_Up_Date;
    private String Return_Date;



    private boolean isProcessed;
    private String Created_At;
    private String Updated_At;
}
