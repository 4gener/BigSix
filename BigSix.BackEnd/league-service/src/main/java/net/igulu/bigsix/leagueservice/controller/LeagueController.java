package net.igulu.bigsix.leagueservice.controller;

import com.google.gson.Gson;
import net.igulu.bigsix.leagueservice.model.League;
import net.igulu.bigsix.leagueservice.service.LeagueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RestController
public class LeagueController {

    private final LeagueService service;

    LeagueController(LeagueService leagueService) {
        this.service = leagueService;
    }

    @RequestMapping(value = "/print", method = RequestMethod.GET)
    public ResponseEntity print(HttpSession session) {
        System.out.println(session.getAttribute("user_id"));
        return new ResponseEntity(session.getAttribute("user_id"), HttpStatus.OK);
    }

    @RequestMapping(value = "/league", method = RequestMethod.GET)
    public ArrayList<League> getLeagues(HttpSession session) {
        String userId = session.getAttribute("user_id").toString();
        return service.findLeaguesByAdminId(userId);
    }

    @RequestMapping(value = "/league", method = RequestMethod.POST)
    public League createLeague(HttpSession session, @RequestBody String body) {
        Gson g = new Gson();
        League league = g.fromJson(body, League.class);
        String userId = session.getAttribute("user_id").toString();
        league.setAdminId(userId);
        service.saveLeague(league);
        return league;
    }

}
