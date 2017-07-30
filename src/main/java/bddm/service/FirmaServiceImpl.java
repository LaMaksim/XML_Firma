package bddm.service;

import bddm.domain.Firma;
import bddm.repository.FirmaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirmaServiceImpl implements FirmaService {

    @Autowired
    private FirmaRepo repo;

    @Override
    public Firma save(Firma frm) {
        return repo.save(frm);
    }

    @Override
    public List<Firma> getAll() {
        return repo.findAll();
    }
}
