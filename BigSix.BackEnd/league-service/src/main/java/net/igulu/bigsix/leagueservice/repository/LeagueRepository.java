package net.igulu.bigsix.leagueservice.repository;

import net.igulu.bigsix.leagueservice.model.League;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface LeagueRepository extends MongoRepository<League, Integer> {

    ArrayList<League> findLeaguesByAdminId(String adminId);

    League findLeagueById(Integer Id);

}
