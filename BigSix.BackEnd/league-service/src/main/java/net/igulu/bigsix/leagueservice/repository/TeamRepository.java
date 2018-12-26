package net.igulu.bigsix.leagueservice.repository;

import net.igulu.bigsix.leagueservice.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, String> {

}
