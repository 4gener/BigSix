package net.igulu.bigsix.leagueservice.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

enum MatchResult {
    DRAW_GAME, HOST_WIN, GUEST_WIN
}

@Document
public class Match implements Serializable {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Field("id")
    private String id;

    @Field("host_team_id")
    private String hostTeamId;

    @Field("guest_team_id")
    private String guestTeamId;

    @Field("league_id")
    private String leagueId;

    @Field("host_team_score")
    private Integer hostTeamScore;

    @Field("guest_team_score")
    private Integer guestTeamScore;

    @Field("match_result")
    private MatchResult matchResult;

}
