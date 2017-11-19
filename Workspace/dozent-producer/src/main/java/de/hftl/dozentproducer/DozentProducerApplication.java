package de.hftl.dozentproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DozentProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DozentProducerApplication.class, args);
	}
}
