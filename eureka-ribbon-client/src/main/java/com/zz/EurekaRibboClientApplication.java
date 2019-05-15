package com.zz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class EurekaRibboClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaRibboClientApplication.class, args);
	}

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/hi")
	public String test(){
		return restTemplate.getForObject("http://eureka-client/sayHI",String.class);
	}
}
