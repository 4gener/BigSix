package net.igulu.bigsix.leagueservice.service;

import net.igulu.bigsix.leagueservice.model.League;
import net.igulu.bigsix.leagueservice.model.Team;
import net.igulu.bigsix.leagueservice.repository.LeagueRepository;
import net.igulu.bigsix.leagueservice.repository.MatchRepository;
import net.igulu.bigsix.leagueservice.repository.TeamRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class LeagueServiceImpl implements LeagueService {

    @Resource
    private LeagueRepository leagueRepository;

    @Resource
    private TeamRepository teamRepository;

    @Resource
    private MatchRepository matchRepository;


    @Override
    public ArrayList<League> findLeaguesByAdminId(String adminId) {
        return leagueRepository.findLeaguesByAdminId(adminId);
    }

    @Override
    public League saveLeague(League league) {
        return leagueRepository.save(league);
    }

    @Override
    public League findLeagueById(Integer id) {
        return leagueRepository.findLeagueById(id);
    }

    @Override
    public ArrayList<Team> findTeamsByLeagueId(Integer leagueId) {
        return teamRepository.findTeamsByLeagueId(leagueId);
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team findTeamById(Integer id) {
        return teamRepository.findTeamById(id);
    }
}
