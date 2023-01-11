package com.example.reactivewebClient.controller;

import com.example.reactivewebClient.model.Person;
import com.example.reactivewebClient.model.PersonResponse;
import com.example.reactivewebClient.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Log4j2
public class PersonController {

    @Autowired
    private PersonService personService;
    @GetMapping(value = "/persons/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
        public Mono<Person> getById(@PathVariable Long id) {
        log.info(" get by id");
        return personService.getById(id);
    }
    @GetMapping(value = "/persons",produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Person>findAll(){
        log.info("get All Person");
        return personService.findAll();

    }

    @DeleteMapping(value = "/persons/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Person>deleteById(@PathVariable Long id){
        log.info("delete by id");
        return personService.deleteById(id);
    }

    @PostMapping(value = "/persons")
    public Mono<PersonResponse> addPerson(@RequestBody Person person){
        log.info("update person");
        return personService.addPerson(person);
    }
    @PutMapping(value = "/persons/{id}")
    public Mono<Person> updatePerson(@PathVariable Long id, @RequestBody Person person){
        return personService.updatePerson(id,person);
    }

}
