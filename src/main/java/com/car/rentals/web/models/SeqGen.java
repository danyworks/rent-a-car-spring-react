package com.car.rentals.web.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@RequiredArgsConstructor
@Getter
@Setter
@Document(collection = "sequence")
public class SeqGen {

    // ID for use internally in database
    @Id
    private String ID;
    private int SEQ;


}
