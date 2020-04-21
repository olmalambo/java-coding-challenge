package com.mooveit.cars;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
@SpringBootConfiguration
public class CarsApplication {
	@Value("${cars.ford.ingester.runCron}")
	private static String datav;
	

  public static void main(String[] args) {
	  System.out.println(datav);
    SpringApplication.run(CarsApplication.class, args);
  }

}
