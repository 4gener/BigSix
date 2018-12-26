package net.igulu.bigsix.leagueservice.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import javax.persistence.Id;

@Document
public class League implements Serializable {

    @Id
    @Field("id")
    private Integer id;

    private static Integer idCount = 0;

    private Integer generateId() {
        idCount++;
        return idCount;
    }

    @Field("admin_id")
    private String adminId;

    @Field("name")
    private String name;

    @Field("league_type")
    private Integer leagueType;

    @Field("avatar_url")
    private String avatarUrl;

    @Field("introduction")
    private String introduction;

    @Field("match_version")
    private Integer matchVersion;

    public Integer getId() {
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

    League() {
        this.id = generateId();
        this.matchVersion = 0;
    }

    League(Integer leagueType, String avatarUrl, String introduction) {
        this.id = generateId();
        this.leagueType = leagueType;
        this.avatarUrl = avatarUrl;
        this.introduction = introduction;
        this.matchVersion = 0;
    }
}
