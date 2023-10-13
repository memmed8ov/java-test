package com.example.demo.controller;

import com.example.demo.classes.Country;
import com.example.demo.classes.Person;
import com.example.demo.service.CountryService;
import com.sun.net.httpserver.Headers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;


    @PostMapping("/countries")
    public Country create(@RequestBody Country country) {
        return countryService.create(country);
    }


    @GetMapping("/countries/{id}")
    public Country get(@PathVariable Integer id) {
        return countryService.get(id);
    }


    @DeleteMapping("/countries/{id}")
    public void delete(@PathVariable Integer id) {
        countryService.delete(id);
    }

    @PutMapping("/countries/{id}")
    public Country update(@PathVariable Integer id, @RequestBody Country country) {
        return countryService.update(id, country);

    }


//    @GetMapping("/country")
//    public List<Country> countryList (){
//        return countryService.countryList();
//    }
}
