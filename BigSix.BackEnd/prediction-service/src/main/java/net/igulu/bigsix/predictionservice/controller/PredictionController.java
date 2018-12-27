package net.igulu.bigsix.predictionservice.controller;

import net.igulu.bigsix.predictionservice.model.Prediction;
import net.igulu.bigsix.predictionservice.model.PredictionType;
import net.igulu.bigsix.predictionservice.service.PredictionService;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/prediction", method = RequestMethod.GET)
    public Prediction makePrediction(@RequestParam("host_team_id") Integer hostTeamId,
                                     @RequestParam("guest_team_id") Integer guestTeamId,
                                     @RequestParam("type_id") Integer typeId) {
        System.out.println(hostTeamId + guestTeamId + typeId);
        return service.findByHostTeamIdAndGuestTeamIdAndPredictionTypeId(hostTeamId, guestTeamId, typeId);
    }
}
