package net.igulu.bigsix.leagueservice.controller;

import com.google.gson.Gson;
import net.igulu.bigsix.leagueservice.serializer.MatchListSerializer;
import net.igulu.bigsix.leagueservice.model.League;
import net.igulu.bigsix.leagueservice.model.Match;
import net.igulu.bigsix.leagueservice.model.Team;
import net.igulu.bigsix.leagueservice.service.LeagueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import static java.lang.Integer.parseInt;

@RestController
public class LeagueController {

    private final LeagueService service;

    LeagueController(LeagueService leagueService) {
        this.service = leagueService;
    }

    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @RequestMapping(value = "/match", method = RequestMethod.POST)
    public ResponseEntity saveMatchesByFile(@RequestParam("league_id") String id, @RequestParam("file") MultipartFile file) {
        File f = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            try {
                InputStream ins = file.getInputStream();
                f = new File(file.getOriginalFilename());
                inputStreamToFile(ins, f);
            } catch (Exception e) {

            }
        }
        String path = f.getPath();
        Integer count = 0;
        try {
            Reader in = new FileReader(f.getPath());
            Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
            for (CSVRecord record : records) {
                count++;
                String date = record.get(0);
                Integer hostTeamId = parseInt(record.get(1));
                Integer guestTeamId = parseInt(record.get(2));
                Integer hostTeamScore = parseInt(record.get(3));
                Integer guestTeamScore = parseInt(record.get(4));
                Integer matchResult = parseInt(record.get(5));
                Integer leagueId = parseInt(record.get(6));
                Match match = new Match(hostTeamId, guestTeamId, leagueId, hostTeamScore, guestTeamScore, matchResult, date);
                service.saveMatch(match);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ResponseEntity(count, HttpStatus.OK);
    }

    @RequestMapping(value = "/match", method = RequestMethod.GET)
    public ArrayList<MatchListSerializer> getMatchesByTeamId(@RequestParam(value = "team_id", required = false, defaultValue = "0") Integer teamId,
                                                             @RequestParam(value = "league_id", required = false, defaultValue = "0") Integer leagueId) {
        if (teamId > 0) {
            System.out.println("team");
            return service.getMatchesByTeamId(teamId);
        }
        if (leagueId > 0) {
            System.out.println("league");
            return service.getMatchesByLeagueId(leagueId);
        }
        return new ArrayList<MatchListSerializer>();
    }

}
