package net.igulu.bigsix.predictionservice.service;

import net.igulu.bigsix.predictionservice.model.Prediction;
import net.igulu.bigsix.predictionservice.model.PredictionType;

import java.util.ArrayList;

public interface PredictionService {

    ArrayList<PredictionType> findAllPredictionTypes();

    PredictionType findPredictionTypeById(Integer id);

    Prediction savePrediction(Prediction prediction);

    Prediction findByHostTeamIdAndGuestTeamIdAndPredictionTypeId(Integer hostTeamId, Integer guestTeamId, Integer predictionTypeId);

}
