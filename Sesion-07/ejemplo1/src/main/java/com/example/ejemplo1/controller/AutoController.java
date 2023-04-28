package com.example.ejemplo1.controller;

import com.example.ejemplo1.entity.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autos")
@Slf4j
public class AutoController {

    @GetMapping("/auto")
    public String saluda(){
       return "Hola Autos";
    }

    @PostMapping("/auto")
    public void recibe(@RequestBody Auto auto){
        log.info(auto.toString());
    }

}
