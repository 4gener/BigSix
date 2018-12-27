package net.igulu.bigsix.leagueservice.repository;

import net.igulu.bigsix.leagueservice.model.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface MatchRepository extends MongoRepository<Match, Integer> {

    ArrayList<Match> getMatchesByLeagueId(Integer leagueId);

    ArrayList<Match> getMatchesByHostTeamIdOrGuestTeamIdOrderByMatchDate(Integer hostTeamId, Integer guestTeamId);

}
