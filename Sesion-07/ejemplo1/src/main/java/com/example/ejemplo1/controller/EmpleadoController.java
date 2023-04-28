package com.example.ejemplo1.controller;

import com.example.ejemplo1.entity.Empleado;
import com.example.ejemplo1.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping
    private Flux<Empleado> getAllEmpleados(){
        return empleadoRepository.findAllEmpleados();
    }
}
