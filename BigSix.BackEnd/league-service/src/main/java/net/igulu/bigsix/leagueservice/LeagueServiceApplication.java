package net.igulu.bigsix.leagueservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LeagueServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeagueServiceApplication.class, args);
    }

}

