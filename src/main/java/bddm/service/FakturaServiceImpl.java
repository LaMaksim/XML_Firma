package bddm.service;

import bddm.domain.Faktura;
import bddm.repository.FakturaRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FakturaServiceImpl implements FakturaService {

    @Autowired
    private FakturaRepo repo;

    @Override
    public Faktura save(Faktura fkt) {
        return repo.save(fkt);
    }

    @Override
    public List<Faktura> getAll() {
        return repo.findAll();
    }
}
