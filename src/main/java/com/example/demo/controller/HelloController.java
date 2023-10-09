package com.example.demo.controller;

import com.example.demo.classes.Person;
import com.example.demo.service.HelloService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/hello")
    public String sayHello(@RequestParam String name) {
        System.out.println(Thread.currentThread().getName());

        return helloService.sayHello(name);
    }

    @RequestMapping(value = "/hello/{sagol}", headers = "taleh")
    public ResponseEntity<?> sayHello2(@RequestBody Person person) {

        if (person.getAge() > 100) {
            return ResponseEntity.badRequest()
                    .header("taleh", "122312321")
                    .body("age cannot be more than 100");
        }

        return ResponseEntity.ok()
                .header("reyhan", "21312321")
                .body(person);
    }

}
