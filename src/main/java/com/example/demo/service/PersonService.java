package com.example.demo.service;

import com.example.demo.classes.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private final List<Person> list = new ArrayList<>();


    // bura gonderilen parametrleri liste elave etmeliyem
    // bura gonderilen name varsa age deyish, yoxdusa elave ele

    public void create(Person person) {
        boolean tapildimi = false;

        for (Person personh : list) {
            if (personh.getName().equals(person.getName())) {
                tapildimi = true;
                personh.setAge(person.getAge());
            }
        }

        System.out.println("Emeliyyat bitdi");

        if (!tapildimi) {
            Person newPerson = new Person();
            newPerson.setName(person.getName());
            newPerson.setAge(person.getAge());
            list.add(newPerson);
        }
    }

    public List<Person> list() {
        return list;
    }

    public void delete(String name) {
        for (Person person : list) {
            if (person.getName().equals(name)) {
                list.remove(person);
            }
        }
    }

    public ResponseEntity<String> update(String name, Person age) {

        boolean tapildimi = false;

        for (Person person : list) {
            if (person.getName().equals(name)) {
                tapildimi = true;
                person.setAge(age.getAge());
            }
        }

        if (!tapildimi) {
            return ResponseEntity.badRequest().body("400 error");
        }

        return ResponseEntity.badRequest().body("400 error");
    }

    public Person get(String name) {
        for (Person person : list) {
            if (person.getName().equals(name)) {
                return person;
            }

        }
       return null;
    }
}
