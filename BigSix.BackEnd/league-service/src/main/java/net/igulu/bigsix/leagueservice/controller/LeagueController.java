package net.igulu.bigsix.leagueservice.controller;

import com.google.gson.Gson;
import net.igulu.bigsix.leagueservice.model.League;
import net.igulu.bigsix.leagueservice.model.Team;
import net.igulu.bigsix.leagueservice.service.LeagueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ArrayList<League> findLeaguesByAdminId(HttpSession session) {
        String userId = session.getAttribute("user_id").toString();
        return service.findLeaguesByAdminId(userId);
    }

    @RequestMapping(value = "/league", method = RequestMethod.POST)
    public League saveLeague(HttpSession session, @RequestBody String body) {
        Gson g = new Gson();
        League league = g.fromJson(body, League.class);
        String userId = session.getAttribute("user_id").toString();
        league.setAdminId(userId);
        return service.saveLeague(league);
    }

    @RequestMapping(value = "/league/{id}", method = RequestMethod.GET)
    public League findLeagueById(@PathVariable("id") Integer id) {
        return service.findLeagueById(id);
    }

    @RequestMapping(value = "/team", method = RequestMethod.GET)
    public ArrayList<Team> findTeamsByAdminId(@RequestParam("league_id") Integer leagueId) {
        return service.findTeamsByLeagueId(leagueId);
    }

    @RequestMapping(value = "/team", method = RequestMethod.POST)
    public Team saveTeam(@RequestBody String body) {
        Gson g = new Gson();
        Team team = g.fromJson(body, Team.class);
        return service.saveTeam(team);
    }

    @RequestMapping(value = "/team/{id}", method = RequestMethod.GET)
    public Team findTeamById(@PathVariable("id") Integer id) {
        return service.findTeamById(id);
    }

}
