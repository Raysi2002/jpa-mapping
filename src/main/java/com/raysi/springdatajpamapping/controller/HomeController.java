package com.raysi.springdatajpamapping.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(){
        return """
                <header style="text-align: center"><h1>Welcome To JPA Mapping</h1></header>
                <h3 style="text-align: center">
                    1.	One-to-One: Each library has exactly one address. <br>
                    2.	One-to-Many: A library can have many books. <br>
                    3.	Many-to-One: Each book belongs to one library. <br>
                    4.	Many-to-Many:
                </h3>
                """;
    }
}
