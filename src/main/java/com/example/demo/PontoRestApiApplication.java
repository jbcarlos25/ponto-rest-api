package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
/* Excluindo segurança do token
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
*/
@SpringBootApplication
@EnableCaching
public class PontoRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PontoRestApiApplication.class, args);
	}

}
