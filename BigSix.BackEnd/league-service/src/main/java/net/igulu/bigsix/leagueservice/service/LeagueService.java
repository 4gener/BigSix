package net.igulu.bigsix.leagueservice.service;

import net.igulu.bigsix.leagueservice.model.League;

import java.util.ArrayList;

public interface LeagueService {

    ArrayList<League> findLeaguesByAdminId(String adminId);

    League saveLeague(League league);

}

