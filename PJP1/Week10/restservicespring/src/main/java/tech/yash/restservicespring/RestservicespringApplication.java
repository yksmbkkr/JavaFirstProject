package tech.yash.restservicespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"tech.yash"})
public class RestservicespringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestservicespringApplication.class, args);
	}

}
