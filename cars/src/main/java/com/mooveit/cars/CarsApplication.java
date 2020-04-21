package com.mooveit.cars;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
@EnableJpaRepositories("com.mooveit.cars.repositories")
@PropertySource("classpath:application.yml")
public class CarsApplication {
	@Value("${cars.ford.ingester.runCron}")
	private static String datav;
	

  public static void main(String[] args) {
	  System.out.println(datav);
    SpringApplication.run(CarsApplication.class, args);
  }

}
