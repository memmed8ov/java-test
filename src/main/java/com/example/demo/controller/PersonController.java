package com.example.demo.controller;

import com.example.demo.classes.Person;
import com.example.demo.service.PersonService;
import com.sun.net.httpserver.Headers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {
    // metod,action,end point
    //add----> /person/add
    //list---->   /person/list

    private final PersonService personService;
    private final HelloController helloController;

    //bu (name,age)parametrlere uygun person duzeldib ,gonderecey PersonService-e

    //add metodunu cagiran zaman namei ve agei goturdum ,name gore axtariram listde bu name yeni nami reyhan olan
    // bir person varmi eger yoxdusa bunu elave etmeliyem eger varsa elave etmek yerine onun age ni deyisirsen

    @PostMapping("/persons") // POST
    public void create(@RequestBody Person person) {
        personService.create(person);
    }


    @GetMapping("/person")
    public List<Person> list() {
        return personService.list();
    }

    @GetMapping("/persons/{name}")
    public Person get(@PathVariable String name) {
        return personService.get(name);
    }


    @DeleteMapping("/person/{name}")
    public void delete(@PathVariable String name) {
        personService.delete(name);
    }

    @PutMapping("/person/{name}")
    public ResponseEntity<?> update(@PathVariable String name, @RequestBody Person person, @RequestHeader Headers headers) {
        return personService.update(name, person);

    }
}
