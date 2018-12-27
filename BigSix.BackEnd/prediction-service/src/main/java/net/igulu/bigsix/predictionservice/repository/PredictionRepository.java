package net.igulu.bigsix.predictionservice.repository;

import net.igulu.bigsix.predictionservice.model.Prediction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PredictionRepository extends MongoRepository<Prediction, Integer> {

    Prediction findByHostTeamIdAndGuestTeamIdAndPredictionTypeId(Integer hostTeamId, Integer guestTeamId, Integer predictionTypeId);

}
