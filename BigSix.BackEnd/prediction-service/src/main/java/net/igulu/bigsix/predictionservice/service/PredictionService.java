package net.igulu.bigsix.predictionservice.service;

import net.igulu.bigsix.predictionservice.model.PredictionType;

import java.util.ArrayList;

public interface PredictionService {

    ArrayList<PredictionType> findAllPredictionTypes();

    PredictionType findPredictionTypeById(Integer id);

}
