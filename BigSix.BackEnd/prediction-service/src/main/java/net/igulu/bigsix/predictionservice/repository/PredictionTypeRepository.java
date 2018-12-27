package net.igulu.bigsix.predictionservice.repository;

import net.igulu.bigsix.predictionservice.model.PredictionType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface PredictionTypeRepository extends MongoRepository<PredictionType, Integer> {

    ArrayList<PredictionType> findAll();

    PredictionType getById(Integer id);

}
