package net.igulu.bigsix.predictionservice.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Document
public class Prediction {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Field("id")
    private String id;

    @Field("host_team_id")
    private String hostTeamId;

    @Field("guest_team_id")
    private String guestTeamId;

    @Field("host_win_rate")
    private Float hostWinRate;

    @Field("draw_game_rate")
    private Float drawGameRate;

    @Field("guest_win_rate")
    private Float guestWinRate;

    @Field("prediction_type_id")
    private String predictionTypeId;

    @Field("version")
    private Integer version;

    @Field("view_count")
    private Integer viewCount;

}
