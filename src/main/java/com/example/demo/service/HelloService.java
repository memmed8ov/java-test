package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Taleh   34
// Reyhan  43

// Integer count ==>>  43

@Service
public class HelloService {

    // Key:   name  String
    // Value: count Integer
    // keyByValue; keyValueMap
    private final Map<String, Integer> nameCountMap = new ConcurrentHashMap<>(); // rw test passed

    public String sayHello(String name) {
        // map name ve count elave elemelidir (count 1 vahid artiraraq)
        nameCountMap.put(name, nameCountMap.getOrDefault(name, 0) + 1); // write

        // ekrana cixarir

        return "hello " + name + nameCountMap.get(name);
    }

}
