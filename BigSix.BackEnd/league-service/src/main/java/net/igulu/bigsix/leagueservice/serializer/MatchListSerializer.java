package net.igulu.bigsix.leagueservice.serializer;

import net.igulu.bigsix.leagueservice.model.Match;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

public class MatchListSerializer {
    private Integer id;

    public MatchListSerializer(Match match, String hostTeamAvatarUrl, String guestTeamAvatarUrl, String hostTeamName, String guestTeamName) {
        this.id = match.getId();
        this.hostTeamId = match.getHostTeamId();
        this.guestTeamId = match.getGuestTeamId();
        this.leagueId = match.getLeagueId();
        this.hostTeamScore = match.getHostTeamScore();
        this.guestTeamScore = match.getGuestTeamScore();
        this.matchResult = match.getMatchResult();
        this.matchDate = match.getMatchDate();
        this.hostTeamAvatarUrl = hostTeamAvatarUrl;
        this.guestTeamAvatarUrl = guestTeamAvatarUrl;
        this.hostTeamName = hostTeamName;
        this.guestTeamName = guestTeamName;
    }

    private Integer hostTeamId;

    private Integer guestTeamId;

    private Integer leagueId;

    private Integer hostTeamScore;

    private String hostTeamAvatarUrl;

    private String guestTeamAvatarUrl;

    private String hostTeamName;

    private String guestTeamName;

    private Integer guestTeamScore;

    private Integer matchResult;

    private String matchDate;

    public Integer getId() {
        return id;
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

    public String getHostTeamAvatarUrl() {
        return hostTeamAvatarUrl;
    }

    public String getGuestTeamAvatarUrl() {
        return guestTeamAvatarUrl;
    }

    public String getHostTeamName() {
        return hostTeamName;
    }

    public String getGuestTeamName() {
        return guestTeamName;
    }
}
