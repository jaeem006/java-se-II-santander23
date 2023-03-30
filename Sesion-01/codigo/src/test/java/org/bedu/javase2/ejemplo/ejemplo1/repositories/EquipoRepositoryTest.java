package org.bedu.javase2.ejemplo.ejemplo1.repositories;

import org.bedu.javase2.ejemplo.ejemplo1.models.Equipo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ComponentScan(basePackages = "org.bedu.javase2.ejemplo.ejemplo1")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EquipoRepositoryTest {

    @Autowired
    private EquipoRepository repository;

    @BeforeAll
    void cleanDatabase(){
        repository.deleteAll();
    }

    @Test
    @DisplayName("Guardado")
    void canSave(){
        Equipo e = new Equipo();
        e.setNombre("prueba");

        e = repository.save(e);

        assertNotNull(e.getId());
    }



}