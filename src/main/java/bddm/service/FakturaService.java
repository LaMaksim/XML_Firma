package bddm.service;

import bddm.domain.Faktura;
import bddm.domain.PaymentStatus;
import bddm.dto.soap.DTOUplatnica;

import java.util.List;

public interface FakturaService {

    Faktura save(Faktura fkt);

    Faktura getOne(Long id);

    List<Faktura> getAll();

    PaymentStatus pay(Faktura faktura, DTOUplatnica uplatnica);
}
