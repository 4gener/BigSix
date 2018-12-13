package net.igulu.bigsix.predictionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PredictionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PredictionServiceApplication.class, args);
	}

}

