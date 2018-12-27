package net.igulu.bigsix.leagueservice.service;

import net.igulu.bigsix.leagueservice.serializer.MatchListSerializer;
import net.igulu.bigsix.leagueservice.model.League;
import net.igulu.bigsix.leagueservice.model.Match;
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

    @Override
    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    private ArrayList<MatchListSerializer> matchesToMatchListSerializers(ArrayList<Match> matches) {
        ArrayList<MatchListSerializer> matchListSerializers = new ArrayList<MatchListSerializer>();
        for (Match match : matches) {
            String hostTeamAvatarUrl = teamRepository.findTeamById(match.getHostTeamId()).getAvatarUrl();
            String guestTeamAvatarUrl = teamRepository.findTeamById(match.getGuestTeamId()).getAvatarUrl();
            String hostTeamName = teamRepository.findTeamById(match.getHostTeamId()).getName();
            String guestTeamName = teamRepository.findTeamById(match.getGuestTeamId()).getName();
            matchListSerializers.add(new MatchListSerializer(match, hostTeamAvatarUrl, guestTeamAvatarUrl, hostTeamName, guestTeamName));
        }
        return matchListSerializers;
    }

    @Override
    public ArrayList<MatchListSerializer> getMatchesByLeagueId(Integer leagueId) {
        ArrayList<Match> matches = matchRepository.getMatchesByLeagueId(leagueId);
        return matchesToMatchListSerializers(matches);
    }

    @Override
    public ArrayList<MatchListSerializer> getMatchesByTeamId(Integer teamId) {
        ArrayList<Match> matches = matchRepository.getMatchesByHostTeamIdOrGuestTeamIdOrderByMatchDate(teamId, teamId);
        return matchesToMatchListSerializers(matches);
    }
}
