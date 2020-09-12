package com.car.rentals.web.repositories;

import com.car.rentals.web.models.SeqGen;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeqGenRepository extends MongoRepository<SeqGen,String> {


}
