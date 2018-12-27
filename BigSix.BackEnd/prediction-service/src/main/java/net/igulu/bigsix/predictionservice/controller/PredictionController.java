package net.igulu.bigsix.predictionservice.controller;

import net.igulu.bigsix.predictionservice.model.PredictionType;
import net.igulu.bigsix.predictionservice.service.PredictionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
public class PredictionController {

    private final PredictionService service;

    PredictionController(PredictionService service) {
        this.service = service;
    }

    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public ArrayList<PredictionType> getAllPredictionType() {
        return service.findAllPredictionTypes();
    }

    @RequestMapping(value = "/type/{id}", method = RequestMethod.GET)
    public PredictionType getAllPredictionType(@PathVariable("id") Integer id) {
        return service.findPredictionTypeById(id);
    }
}
