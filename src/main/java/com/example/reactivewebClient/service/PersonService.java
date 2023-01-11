package com.example.reactivewebClient.service;

import com.example.reactivewebClient.model.Person;
import com.example.reactivewebClient.model.PersonResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Log4j2
public class PersonService {
    private final WebClient.Builder webClient;

    public PersonService(WebClient.Builder webClient) {
        this.webClient = webClient;
    }


    @Value("${base.url}")
    private String baseurl;

    public Mono<Person> getById(Long id) {
        return webClient.build().get()
                .uri(baseurl+"/persons/{id}",id)
                .retrieve()
                .bodyToMono(Person.class);
    }

             public Flux<Person> findAll() {
             return webClient.build().get()
                .uri(baseurl+"/persons")
                .retrieve()
                .bodyToFlux(Person.class);
    }

    public Mono<Person>deleteById(Long id){
        return webClient.build().delete()
                .uri(baseurl+"/persons/{id}",id)
                .retrieve()
                .bodyToMono(Person.class);
    }

    public Mono<PersonResponse>addPerson(Person person){
        return webClient.build().post()
                .uri(baseurl+"/persons")
                .body(Mono.just(person),Person.class)
                .retrieve()
                .bodyToMono(PersonResponse.class);
    }
     public Mono<Person> updatePerson(Long id , Person person){
        return webClient.build().put()
                .uri(baseurl+"/persons/{id}")
                .retrieve()
                .bodyToMono(Person.class);
     }
}
