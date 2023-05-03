package com.example.demo.negocio;

import com.example.demo.model.Casa;
import com.example.demo.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CasaServiceImpl implements CasaService{

    private final CasaRepository repository;

    @Autowired
    public CasaServiceImpl(CasaRepository repository){
        this.repository = repository;
    }

    @Override
    public void guardar(Casa casa) {
        if (casa.getJefeDeFamilia() == null)
            throw new RuntimeException("Se debe tener un padre de familia");

        casa.setJefeDeFamilia(
                casa.getJefeDeFamilia().toUpperCase());

        repository.save(casa);
    }

    @Override
    public Casa buscaPorId(Long id) {
        return repository.findById(id).get();
    }
}
