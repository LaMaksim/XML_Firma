package bddm.service;

import bddm.client.UplatnicaClient;
import bddm.domain.Faktura;
import bddm.domain.PaymentStatus;
import bddm.dto.soap.DTOUplatnica;
import bddm.dto.soap.UplatnicaResponse;
import bddm.repository.FakturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class FakturaServiceImpl implements FakturaService {

    @Autowired
    private FakturaRepo repo;

    @Autowired
    private UplatnicaClient client;

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

    @Override
    public PaymentStatus pay(Faktura faktura, DTOUplatnica uplatnica) {
        UplatnicaResponse response = client.payUplatnica(uplatnica);

        switch (response.getUplatnica().getContent()) {
            case 0:
                return PaymentStatus.FAILURE;
            case 1:
                repo.delete(faktura);
                return PaymentStatus.SUCCESS;
            case 2:
                return PaymentStatus.CLEARING;

        }

        return PaymentStatus.FAILURE;
    }
}
