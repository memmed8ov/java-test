package com.example.demo.service;

import com.example.demo.classes.Country;
import com.example.demo.classes.Person;
import com.example.demo.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository repository;

    public Country create(Country country) {
        return repository.save(country);
    }


    public Country get(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }


    public Country update(Integer id, Country country) {
        country.setId(id);
        return repository.save(country);
    }

}
