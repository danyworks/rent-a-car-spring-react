package com.car.rentals.web.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@RequiredArgsConstructor
@Getter
@Setter
@Document("sales")
public class Sales {

    // ID for use internally in database
    @Id
    private String Sales_Report_ID;

    // Sale details for each day
    private String Date;
    private int Cars_Rented_Today;
    private String Total_Cash_Inflow;
    private String Total_Profit;
    private String Total_Loss;

    // Assets details
    private String Cars_Availble;
    private String Cars_On_Rent;

    private boolean isProcessed;
    private String Created_At;
    private String Updated_At;

}
