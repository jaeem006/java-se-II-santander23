package com.example.demo.controller;

import com.example.demo.model.Casa;
import com.example.demo.negocio.CasaService;
import com.example.demo.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/casa")
public class CasaController {

    private final CasaService service;

    @Autowired
    public CasaController(CasaService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void guardarCasa(@RequestBody Casa casa) {
        service.guardar(casa);
    }

    //KISS
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Casa getCasa(@PathVariable Long id) {
        return service.buscaPorId(id);
    }

}
