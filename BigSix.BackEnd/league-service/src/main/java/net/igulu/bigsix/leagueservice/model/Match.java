package net.igulu.bigsix.leagueservice.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.io.Serializable;

@Document
public class Match implements Serializable {

    @Id
    @Field("id")
    private Integer id;

    private static Integer idCount = 0;

    private Integer generateId() {
        idCount++;
        return idCount;
    }

    public Match(Integer hostTeamId, Integer guestTeamId, Integer leagueId, Integer hostTeamScore, Integer guestTeamScore, Integer matchResult, String matchDate) {
        this.id = generateId();
        this.hostTeamId = hostTeamId;
        this.guestTeamId = guestTeamId;
        this.leagueId = leagueId;
        this.hostTeamScore = hostTeamScore;
        this.guestTeamScore = guestTeamScore;
        this.matchResult = matchResult;
        this.matchDate = matchDate;
    }

    @Field("host_team_id")
    private Integer hostTeamId;

    @Field("guest_team_id")
    private Integer guestTeamId;

    @Field("league_id")
    private Integer leagueId;

    @Field("host_team_score")
    private Integer hostTeamScore;

    @Field("guest_team_score")
    private Integer guestTeamScore;

    @Field("match_result")
    private Integer matchResult;

    @Field("match_date")
    private String matchDate;

    public Integer getId() {
        return id;
    }

    public static Integer getIdCount() {
        return idCount;
    }

    public Integer getHostTeamId() {
        return hostTeamId;
    }

    public Integer getGuestTeamId() {
        return guestTeamId;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public Integer getHostTeamScore() {
        return hostTeamScore;
    }

    public Integer getGuestTeamScore() {
        return guestTeamScore;
    }

    public Integer getMatchResult() {
        return matchResult;
    }

    public String getMatchDate() {
        return matchDate;
    }
}
