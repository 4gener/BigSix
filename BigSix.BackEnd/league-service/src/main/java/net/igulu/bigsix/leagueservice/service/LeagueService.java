package net.igulu.bigsix.leagueservice.service;

import net.igulu.bigsix.leagueservice.model.League;
import net.igulu.bigsix.leagueservice.model.Team;

import java.util.ArrayList;

public interface LeagueService {

    ArrayList<League> findLeaguesByAdminId(String adminId);

    League saveLeague(League league);

    League findLeagueById(Integer id);

    ArrayList<Team> findTeamsByLeagueId(Integer leagueId);

    Team saveTeam(Team team);

    Team findTeamById(Integer id);

}

