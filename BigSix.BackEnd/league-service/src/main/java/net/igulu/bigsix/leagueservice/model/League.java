package net.igulu.bigsix.leagueservice.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.GeneratedValue;

@Document
public class League implements Serializable {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Field("id")
    private String id;

    @Field("admin_id")
    private String adminId;

    @Field("name")
    private String name;

    @Field("league_type")
    private Integer leagueType;

    @Field("avatar_url")
    private String avatarUrl;

    public String getId() {
        return id;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminId() {
        return adminId;
    }

    public String getName() {
        return name;
    }

    public Integer getLeagueType() {
        return leagueType;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getIntroduction() {
        return introduction;
    }

    public Integer getMatchVersion() {
        return matchVersion;
    }

    @Field("introduction")
    private String introduction;

    @Field("match_version")
    private Integer matchVersion;

    League() {
    }

    League(Integer leagueType, String avatarUrl, String introduction){
        this.id = this.id = UUID.randomUUID().toString();
        this.leagueType = leagueType;
        this.avatarUrl = avatarUrl;
        this.introduction = introduction;
    }
}
