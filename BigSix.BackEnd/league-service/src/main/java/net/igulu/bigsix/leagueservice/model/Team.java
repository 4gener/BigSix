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
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Field("id")
    private String id;

    @Field("league_id")
    private String leagueId;

    @Field("name")
    private String name;

    @Field("avatar_url")
    private String avatarUrl;

    @Field("introduction")
    private String introduction;

}
