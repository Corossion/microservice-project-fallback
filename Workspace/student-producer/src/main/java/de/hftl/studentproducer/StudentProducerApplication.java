package de.hftl.studentproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StudentProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentProducerApplication.class, args);
	}
}
