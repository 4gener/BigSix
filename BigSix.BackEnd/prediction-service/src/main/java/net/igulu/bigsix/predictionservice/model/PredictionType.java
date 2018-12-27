package net.igulu.bigsix.predictionservice.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Document
public class PredictionType implements Serializable {

    @Id
    @Field("id")
    private Integer id;

    private static Integer idCount = 0;

    private Integer generateId() {
        idCount++;
        return idCount;
    }

    public String getName() {
        return name;
    }

    public Integer getHandicap() {
        return handicap;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public PredictionType() {
    }

    public Integer getId() {
        return id;
    }

    public static Integer getIdCount() {
        return idCount;
    }

    @Field("name")
    private String name;

    @Field("handicap")
    private Integer handicap;

    @Field("is_default")
    private Boolean isDefault;

}
