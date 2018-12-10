package net.igulu.bigsix.authservice.model;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.util.DigestUtils;

import javax.persistence.GeneratedValue;

@Document
public class User implements Serializable {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Field("id")
    private String id;

    @Field("username")
    @Indexed(unique = true)
    private String username;

    @JsonIgnore
    @Field("password_salt")
    private String password_salt;
    @JsonIgnore
    @Field("password_hash")
    private String password_hash;

    public User() {
    }

    public User(String username, String password) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.setPassword(password);
    }

    private String generateSalt() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private void setPassword(String password) {
        this.password_salt = generateSalt();
        this.password_hash = DigestUtils.md5DigestAsHex((password + password_salt).getBytes());
    }

    public Boolean checkPassword(String password) {
        return DigestUtils.md5DigestAsHex((password + this.password_salt).getBytes()).equals(this.password_hash);
    }

    @Override
    public String toString() {
        return String.format(
                "User [ id = %s , username = %s ]",
                id, username);
    }
}
