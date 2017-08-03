package bddm.service;

import bddm.domain.Faktura;
import bddm.repository.FakturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class FakturaServiceImpl implements FakturaService {

    @Autowired
    private FakturaRepo repo;

    @Override
    public Faktura save(Faktura fkt) {
        return repo.save(fkt);
    }

    @Override
    public Faktura getOne(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Faktura> getAll() {
        return repo.findAll();
    }
}
