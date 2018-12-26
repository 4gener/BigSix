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
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Field("id")
    private String id;

    @Field("name")
    private String name;

    @Field("handicap")
    private Integer handicap;

    @Field("is_default")
    private Boolean isDefault;

}
