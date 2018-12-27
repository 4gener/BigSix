package net.igulu.bigsix.leagueservice.service;

import net.igulu.bigsix.leagueservice.serializer.MatchListSerializer;
import net.igulu.bigsix.leagueservice.model.League;
import net.igulu.bigsix.leagueservice.model.Match;
import net.igulu.bigsix.leagueservice.model.Team;

import java.util.ArrayList;
import java.util.List;

public interface LeagueService {

    ArrayList<League> findLeaguesByAdminId(String adminId);

    League saveLeague(League league);

    League findLeagueById(Integer id);

    ArrayList<Team> findTeamsByLeagueId(Integer leagueId);

    Team saveTeam(Team team);

    List<Team> saveTeams(List<Team> teams);

    Team findTeamById(Integer id);

    Match saveMatch(Match match);

    ArrayList<MatchListSerializer> getMatchesByLeagueId(Integer leagueId);

    ArrayList<MatchListSerializer> getMatchesByTeamId(Integer teamId);

}

