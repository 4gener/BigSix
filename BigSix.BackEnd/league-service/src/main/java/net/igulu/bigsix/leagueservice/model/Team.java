package net.igulu.bigsix.leagueservice.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Document
public class Team implements Serializable {

    @Id
    @Field("id")
    private Integer id;

    private static Integer idCount = 0;

    private Integer generateId() {
        idCount++;
        return idCount;
    }

    @Field("league_id")
    private Integer leagueId;

    @Field("name")
    private String name;

    @Field("avatar_url")
    private String avatarUrl;

    @Field("introduction")
    private String introduction;

    public Team(){
        this.id = generateId();
    }

    public Team(Integer leagueId, String name, String avatarUrl, String introduction) {
        this.id = generateId();
        this.leagueId = leagueId;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.introduction = introduction;
    }

    public Integer getId() {
        return id;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getIntroduction() {
        return introduction;
    }
}
