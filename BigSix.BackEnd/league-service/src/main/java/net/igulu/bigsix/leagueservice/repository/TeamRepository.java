package net.igulu.bigsix.leagueservice.repository;

import net.igulu.bigsix.leagueservice.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface TeamRepository extends MongoRepository<Team, Integer> {

    Team findTeamById(Integer id);

    ArrayList<Team> findTeamsByLeagueId(Integer leagueId);

}
