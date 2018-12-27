package net.igulu.bigsix.predictionservice.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Document
public class Prediction {

    @Id
    @Field("id")
    private Integer id;

    private static Integer idCount = 0;

    private Integer generateId() {
        idCount++;
        return idCount;
    }

    @Field("host_team_id")
    private Integer hostTeamId;

    @Field("guest_team_id")
    private Integer guestTeamId;

    @Field("host_win_rate")
    private Double hostWinRate;

    @Field("draw_game_rate")
    private Double drawGameRate;

    public Prediction(Integer hostTeamId, Integer guestTeamId, Integer predictionTypeId) {
        this.id = generateId();
        this.hostTeamId = hostTeamId;
        this.guestTeamId = guestTeamId;
        this.predictionTypeId = predictionTypeId;
        this.version = 1;
        this.viewCount = 1;
        this.hostWinRate = 0.35 + (predictionTypeId - 5) * 0.07 + Math.sqrt(hostTeamId) * 0.01;
        this.guestWinRate = 0.35 - (predictionTypeId - 5) * 0.07 - Math.sqrt(guestTeamId) * 0.01;
        this.drawGameRate = 1 - hostWinRate - guestWinRate;
    }

    @Field("guest_win_rate")
    private Double guestWinRate;

    @Override
    public String toString() {
        return "Prediction{" +
                "id=" + id +
                ", hostTeamId=" + hostTeamId +
                ", guestTeamId=" + guestTeamId +
                ", hostWinRate=" + hostWinRate +
                ", drawGameRate=" + drawGameRate +
                ", guestWinRate=" + guestWinRate +
                ", predictionTypeId=" + predictionTypeId +
                ", version=" + version +
                ", viewCount=" + viewCount +
                '}';
    }

    @Field("prediction_type_id")
    private Integer predictionTypeId;

    @Field("version")
    private Integer version;

    @Field("view_count")
    private Integer viewCount;

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

    public Double getHostWinRate() {
        return hostWinRate;
    }

    public Double getDrawGameRate() {
        return drawGameRate;
    }

    public Double getGuestWinRate() {
        return guestWinRate;
    }

    public Integer getPredictionTypeId() {
        return predictionTypeId;
    }

    public Integer getVersion() {
        return version;
    }

    public Integer getViewCount() {
        return viewCount;
    }
}
