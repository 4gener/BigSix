package net.igulu.bigsix.leagueservice.repository;

import net.igulu.bigsix.leagueservice.model.League;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface LeagueRepository extends MongoRepository<League, String> {

    ArrayList<League> findLeaguesByAdminId(String adminId);

}
