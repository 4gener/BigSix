package net.igulu.bigsix.predictionservice.service;

import net.igulu.bigsix.predictionservice.model.PredictionType;
import net.igulu.bigsix.predictionservice.repository.PredictionTypeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class PredictionServiceImpl implements PredictionService {

    @Resource
    PredictionTypeRepository predictionTypeRepository;

    @Override
    public ArrayList<PredictionType> findAllPredictionTypes() {
        return predictionTypeRepository.findAll();
    }

    @Override
    public PredictionType findPredictionTypeById(Integer id) {
        return predictionTypeRepository.getById(id);
    }
}
