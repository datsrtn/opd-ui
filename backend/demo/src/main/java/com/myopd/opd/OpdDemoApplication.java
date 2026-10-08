package com.myopd.opd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories("com.myopd.opd")
@EntityScan(basePackages = "com.myopd.opd")
public class OpdDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpdDemoApplication.class, args);
		System.out.println("hi");
	}
}
