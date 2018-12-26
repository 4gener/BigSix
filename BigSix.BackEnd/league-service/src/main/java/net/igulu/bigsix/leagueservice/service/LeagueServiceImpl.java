package net.igulu.bigsix.leagueservice.service;

import net.igulu.bigsix.leagueservice.model.League;
import net.igulu.bigsix.leagueservice.repository.LeagueRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class LeagueServiceImpl implements LeagueService {

    @Resource
    private LeagueRepository leagueRepository;

    @Override
    public ArrayList<League> findLeaguesByAdminId(String adminId) {
        return leagueRepository.findLeaguesByAdminId(adminId);
    }

    @Override
    public League saveLeague(League league) {
        return leagueRepository.save(league);
    }

}
