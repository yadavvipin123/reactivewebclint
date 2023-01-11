package com.example.reactivewebClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ReactiveWebClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveWebClientApplication.class, args);
	}

	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

}
