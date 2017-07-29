package bddm.service;

import bddm.domain.Banka;
import bddm.repository.BankaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankaServiceImpl implements BankaService {

    @Autowired
    private BankaRepo repo;

    @Override
    public Banka save(Banka bnk) {
        return repo.save(bnk);
    }

    @Override
    public List<Banka> getAll() {
        return repo.findAll();
    }
}
